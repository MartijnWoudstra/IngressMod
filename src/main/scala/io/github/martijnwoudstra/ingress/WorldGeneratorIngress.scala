package io.github.martijnwoudstra.ingress

import java.util.Random

import cpw.mods.fml.common.IWorldGenerator
import net.minecraft.block.Block
import net.minecraft.init.Blocks
import net.minecraft.world.World
import net.minecraft.world.chunk.IChunkProvider
import net.minecraft.world.gen.feature.{WorldGenMinable, WorldGenerator}
import net.minecraftforge.common.util.ForgeDirection

/*
* @author Martijn Woudstra
* @license LGPL v3
* For the Ingress Mod
*/

object WorldGeneratorIngress extends IWorldGenerator {
  override def generate(random: Random, chunkX: Int, chunkZ: Int, world: World, chunkGenerator: IChunkProvider, chunkProvider: IChunkProvider): Unit = {
    world.provider.dimensionId match {
      case 0 => generateOverworld(random, world, chunkZ, chunkX)
      case 1 => generateEnd(random, world, chunkZ, chunkX)
      case -1 => generateEnd(random, world, chunkZ, chunkX)
      case _ => ;
    }
  }

  /**
   * Adds generation for the overworld. Add oreSpawn like the example below
   * addOreSpawn(block, random, world, xChunk, zChunk, int, int, int, int, int);
   * @param random the random object
   * @param world the world object
   * @param xChunk chunk x coordinate
   * @param zChunk chunk z coordinate
   */
  def generateOverworld(random: Random, world: World, xChunk: Int, zChunk: Int) {
    addPortalSpawnOverworld(IngressPortalBlock, random, world, xChunk, zChunk, 10, 50, 20, 0, 120)
  }

  /**
   *
   * This method adds our protals to the world.
   * It randomizes the coordinates, and does that as many times, as defined in spawnChance.
   * Then it gives all the params to WorldGenPortals, which handles the replacing of the ores for us.
   *
   * @param block The block you want to spawn
   * @param random The Random
   * @param world The world
   * @param blockXPos the blockXpos of a chunk
   * @param blockZPos the blockZpos of a chunk
   * @param minVainSize min vain
   * @param maxVainSize max vain
   * @param chancesToSpawn the chance to spawn. Usually around 2
   * @param minY lowest point to spawn
   * @param maxY highest point to spawn
   */
  def addPortalSpawnOverworld(block: Block, random: Random, world: World, blockXPos: Int, blockZPos: Int, minVainSize: Int, maxVainSize: Int, chancesToSpawn: Int, minY: Int, maxY: Int) {
    for (i <- 0 until chancesToSpawn) {
      val posX = blockXPos + random.nextInt(16)
      val posY = minY + random.nextInt(maxY - minY)
      val posZ = blockZPos + random.nextInt(16)
      new WorldGenPortals(block).generate(world, random, posX, posY, posZ)
    }
  }

  /**
   * Adds generation for the end. Add oreSpawn like the example below
   * addOreSpawn(block, random, world, xChunk, zChunk, int, int, int, int, int);
   * @param random the random object
   * @param world the world object
   * @param xChunk chunk x coordinate
   * @param zChunk chunk z coordinate
   */
  def generateEnd(random: Random, world: World, xChunk: Int, zChunk: Int) {
    //TODO add end generator
  }

  /**
   * Adds generation for the nether. Add oreSpawn like the example below
   * addOreSpawn(block, random, world, xChunk, zChunk, int, int, int, int, int);
   * @param random the random object
   * @param world the world object
   * @param xChunk chunk x coordinate
   * @param zChunk chunk z coordinate
   */
  def generateNether(random: Random, world: World, xChunk: Int, zChunk: Int) {
    //TODO add nether generator
  }

  /**
   *
   * This method adds our block to the world.
   * It randomizes the coordinates, and does that as many times, as defined in spawnChance.
   * Then it gives all the params to WorldGenMinable, which handles the replacing of the ores for us.
   *
   * @param block The block you want to spawn
   * @param random The Random
   * @param world The world
   * @param blockXPos the blockXpos of a chunk
   * @param blockZPos the blockZpos of a chunk
   * @param minVainSize min vain
   * @param maxVainSize max vain
   * @param chancesToSpawn the chance to spawn. Usually around 2
   * @param minY lowest point to spawn
   * @param maxY highest point to spawn
   */
  def addOreSpawnOverworld(block: Block, random: Random, world: World, blockXPos: Int, blockZPos: Int, minVainSize: Int, maxVainSize: Int, chancesToSpawn: Int, minY: Int, maxY: Int) {
    for (i <- 0 until chancesToSpawn) {
      val posX = blockXPos + random.nextInt(16)
      val posY = minY + random.nextInt(maxY - minY)
      val posZ = blockZPos + random.nextInt(16)
      new WorldGenMinable(block, minVainSize + random.nextInt(maxVainSize - minVainSize), Blocks.stone).generate(world, random, posX, posY, posZ)
    }
  }
}

class WorldGenPortals(block: Block) extends WorldGenerator {
  override def generate(world: World, random: Random, x: Int, y: Int, z: Int): Boolean = {
    for (l <- 0 until 64) {
      if ((world.isAirBlock(x, y, z) || world.getBlock(x, y, z).isReplaceable(world, x, y, z)) &&
        world.isSideSolid(x, y - 1, z, ForgeDirection.UP) &&
        world.isAirBlock(x, y + 1, z)) {
        world.setBlock(x, y, z, IngressPortalBlockTop)
      }
    }
    true
  }
}
package io.github.martijnwoudstra.ingress

import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.event.{FMLInitializationEvent, FMLPostInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.registry.GameRegistry

/*
* @author Martijn Woudstra
* @license LGPL v3
* For the Ingress Mod
*/

@Mod(modid = Lib.Modid, name = Lib.Modname, version = Lib.Version, modLanguage = "scala")
object Ingress {

  @Mod.EventHandler
  def preInit(event: FMLPreInitializationEvent): Unit = {
    addBlocksAndItems()
  }

  @Mod.EventHandler
  def init(event: FMLInitializationEvent): Unit = {
    GameRegistry.registerWorldGenerator(WorldGeneratorIngress, 1)
  }

  @Mod.EventHandler
  def postInit(event: FMLPostInitializationEvent): Unit = {

  }

  def addBlocksAndItems(): Unit = {
    GameRegistry.registerBlock(IngressPortalBlock, Strings.IngressPortalBlockName)
    GameRegistry.registerBlock(IngressPortalBlockTop, Strings.IngressPortalBlockTopName)

    GameRegistry.registerItem(IngressGoggles, Strings.IngressGogglesName)
  }
}

object Lib {
  final val Modid = "ingressmod"
  final val Modname = "Ingress Mod"
  final val Version = "@VERSION@"
}

object Strings {
  val IngressPortalBlockName: String = "IngressPortalBlock"
  val IngressPortalBlockTopName: String = "IngressPortalTopBlock"
  val IngressGogglesName: String = "IngressGoggles"
}
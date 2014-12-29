package io.github.martijnwoudstra.ingress
import cpw.mods.fml.common.Mod
import cpw.mods.fml.common.event.{FMLPostInitializationEvent, FMLInitializationEvent, FMLPreInitializationEvent}
import cpw.mods.fml.common.registry.GameRegistry

/*
* @author Martijn Woudstra
* @license LGPL v3
* For the Ingress Mod
*/

@Mod(modid = Lib.Modid, name = Lib.Modname, version = Lib.Version, modLanguage = "scala")
object Ingress {

  @Mod.EventHandler
  def preInit(event: FMLPreInitializationEvent): Unit ={

    addBlocksAndItems()
  }

  def init(event: FMLInitializationEvent): Unit ={

    GameRegistry.registerWorldGenerator(WorldGeneratorIngress, 8)
  }

  def postInit(event: FMLPostInitializationEvent): Unit ={

  }

  def addBlocksAndItems(): Unit ={

  }
}

object Lib{
  val Modid = "ingressmod"
  val Modname = "Ingress Mod"
  val Version = "@VERSION@"
}

object Strings{

}
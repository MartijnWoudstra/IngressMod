package io.github.martijnwoudstra.ingress

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.item.ItemArmor

/*
* @author Martijn Woudstra
* @license LGPL v3
* For the Ingress Mod
*/

object IngressGoggles extends ItemArmor(ItemArmor.ArmorMaterial.IRON, 0, 0) {
  setUnlocalizedName(Strings.IngressGogglesName)
  setCreativeTab(CreativeTabs.tabCombat)
  /*
  //TODO Once you set this goggles on, you will get an HUD, showing XML, portals and more on a compass
   */
}
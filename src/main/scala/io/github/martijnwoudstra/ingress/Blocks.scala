package io.github.martijnwoudstra.ingress

import net.minecraft.block.Block
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs

object IngressPortalBlock extends Block(Material.rock) {
  setBlockName(Strings.IngressPortalBlockName)
  setCreativeTab(CreativeTabs.tabCombat)
  setBlockUnbreakable()
}

object IngressPortalBlockTop extends Block(Material.rock) {
  setBlockName(Strings.IngressPortalBlockTopName)
  setCreativeTab(CreativeTabs.tabCombat)
  setBlockUnbreakable()
}

package me.ddevil.shiroi.ui.component

import org.bukkit.inventory.ItemStack

abstract class SlotDisplay(
        var baseItem: ItemStack
) {
    abstract fun render(): ItemStack
}
package me.ddevil.shiroi.ui.component

import org.bukkit.inventory.ItemStack

class StaticSlotDisplay(baseItem: ItemStack) : SlotDisplay(baseItem) {
    override fun render() = baseItem
}
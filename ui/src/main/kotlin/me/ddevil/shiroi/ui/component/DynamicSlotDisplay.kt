package me.ddevil.shiroi.ui.component

import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta

class DynamicSlotDisplay(
        baseItem: ItemStack,
        val itemStackHandler: (ItemStack) -> Unit,
        val itemMetaHandler: (ItemMeta) -> Unit
) : SlotDisplay(baseItem) {
    override fun render(): ItemStack {
        itemStackHandler(baseItem)
        val meta = baseItem.itemMeta
        itemMetaHandler(meta)
        baseItem.itemMeta = meta
        return baseItem
    }
}
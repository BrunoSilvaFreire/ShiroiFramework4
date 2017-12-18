package me.ddevil.shiroi.ui.component

import me.ddevil.shiroi.ui.component.exception.PositionOccupiedException
import org.bukkit.inventory.ItemStack


class DrawingHandle(private val menu: Menu) {
    private val view: Array<ItemStack?> = arrayOfNulls(menu.area)
    operator fun set(index: Int, item: ItemStack) {
        if (!attemptSet(index, item)) {
            throw PositionOccupiedException(index)
        }
    }

    fun attemptSet(index: Int, item: ItemStack): Boolean {
        if (menu.contains(index)) {
            return false
        }
        view[index] = item
        return true
    }

    operator fun set(x: Int, y: Int, item: ItemStack) {
        this[menu.indexOf(x, y)] = item
    }

    fun attemptSet(x: Int, y: Int, item: ItemStack): Boolean {
        return attemptSet(menu.indexOf(x, y), item)
    }
}
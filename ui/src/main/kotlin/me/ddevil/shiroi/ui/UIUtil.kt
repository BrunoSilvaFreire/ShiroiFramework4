package me.ddevil.shiroi.ui

import me.ddevil.shiroi.ui.component.Menu
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

fun Player.openMenu(menu: Menu) {
    menu.openFor(this)
}

fun createMenu(height: Int, title: String? = null, background: ItemStack? = null, builder: Menu.() -> Unit): Menu {
    val m = Menu(height, title, background)
    m.builder()
    return m
}

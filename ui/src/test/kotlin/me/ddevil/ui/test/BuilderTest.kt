package me.ddevil.ui.test

import me.ddevil.shiroi.ui.component.Button
import me.ddevil.shiroi.ui.component.DynamicSlotDisplay
import me.ddevil.shiroi.ui.component.StaticSlotDisplay
import me.ddevil.shiroi.ui.createMenu
import me.ddevil.shiroi.ui.openMenu
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.inventory.ItemStack
import org.junit.Test
import java.util.*

class BuilderTest {
    @Test
    fun test() {
        val bg = ItemStack(Material.IRON_FENCE)
        val first = createMenu(6, "Hallo") {
            this.background = bg
        }
        val display = StaticSlotDisplay(ItemStack(Material.DIAMOND))
        val second = createMenu(6, "Hello world!", bg) {
            this[0] = Button.redirectButton(display, first)
        }
        Bukkit.getPlayer(UUID.randomUUID()).openMenu(second)
    }
}
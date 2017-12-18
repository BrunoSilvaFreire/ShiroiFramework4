package me.ddevil.shiroi.ui.component

import me.ddevil.shiroi.ui.inventoryMaxSizeX
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder
import org.bukkit.inventory.ItemStack

class Menu @JvmOverloads constructor(
        height: Int,
        title: String? = null,
        background: ItemStack? = null
) : Container(inventoryMaxSizeX, height, background), InventoryHolder {
    private var currentTitle: String? = title

    var title: String?
        get() = currentTitle
        set(value) {
            currentTitle = value
            reloadInventory()
        }

    private fun reloadInventory(): Inventory {
        return Bukkit.createInventory(this, height, title)!!
    }

    private var inventory = reloadInventory()
    private val drawingHandle = DrawingHandle(this)

    override fun getInventory(): Inventory {
        return inventory
    }

    fun openFor(player: Player) {
        render()
        player.openInventory(inventory)
    }

    fun render() {
        render(drawingHandle, 0)
    }

}
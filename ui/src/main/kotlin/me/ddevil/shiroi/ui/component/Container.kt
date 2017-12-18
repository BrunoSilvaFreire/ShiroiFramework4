package me.ddevil.shiroi.ui.component

import me.ddevil.util.math.vector.Vector2i
import org.bukkit.inventory.ItemStack

open class Container
@JvmOverloads
constructor(
        width: Int,
        height: Int,
        background: ItemStack? = null
) : AreaComponent(width, height, background) {


    internal val components = arrayOfNulls<Component>(width * height)
    protected val handle = ContainerHandle(this)
    @JvmOverloads
    fun render(handle: DrawingHandle, inventoryStartIndex: Int, minX: Int, minY: Int, maxX: Int = width, maxY: Int = height) {
        for (x in minX..maxX) {
            for (y in minY..maxY) {
                val component = this[x, y] ?: continue
                component.render(handle, inventoryStartIndex + indexOf(x, y))
            }
        }
    }

    override fun render(handle: DrawingHandle, normalizedInitialIndex: Int) {
        render(handle, normalizedInitialIndex, 0, 0)
    }

    operator fun set(index: Int, component: Component) {
        component.placeInto(handle, index)
    }

    operator fun set(x: Int, y: Int, component: Component) {
        checkOutOfBounds(x, y)
        this[indexOf(x, y)] = component
    }

    operator fun set(position: Vector2i, component: Component) {
        this[position.x, position.y] = component
    }

    operator fun get(x: Int, y: Int): Component? {
        checkOutOfBounds(x, y)
        return this[indexOf(x, y)]
    }

    operator fun get(index: Int): Component? {
        return components[index]
    }

    operator fun contains(index: Int): Boolean {
        return components[index] != null
    }
}


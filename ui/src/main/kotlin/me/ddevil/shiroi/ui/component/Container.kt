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
    private val handle = ContainerHandle(this)

    @JvmOverloads
    fun render(handle: DrawingHandle, inventoryStartIndex: Int, minX: Int, minY: Int, maxX: Int = width, maxY: Int = height) {
        val bg = background
        for (x in minX..maxX) {
            for (y in minY..maxY) {
                val component = getUnsafe(x, y)
                if (component != null) {
                    component.render(handle, inventoryStartIndex + indexOf(x, y))
                } else if (bg != null) {
                    handle[x, y] = bg
                }
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

    fun getUnsafe(x: Int, y: Int) = this[indexOf(x, y)]

    operator fun get(x: Int, y: Int): Component? {
        checkOutOfBounds(x, y)
        return getUnsafe(x, y)
    }

    operator fun get(index: Int): Component? {
        return components[index]
    }

    operator fun contains(index: Int): Boolean {
        return components[index] != null
    }
}


package me.ddevil.shiroi.ui.component

import me.ddevil.util.math.vector.Vector2i

open class Container(width: Int, height: Int) : AreaComponent(width, height) {
    internal val components = arrayOfNulls<Component>(width * height)
    private val handle = ContainerHandle(this)

    operator fun set(index: Int, component: Component) {
        component.placeInto(handle, index)
    }

    operator fun set(position: Vector2i, component: Component) {
        checkOutOfBounds(position)
        this[indexOf(position)] = component
    }

    fun hasComponentIn(index: Int): Boolean {
        return components[index] != null
    }
}


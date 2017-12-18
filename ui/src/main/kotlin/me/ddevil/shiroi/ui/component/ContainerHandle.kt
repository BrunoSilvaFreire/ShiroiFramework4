package me.ddevil.shiroi.ui.component

import me.ddevil.shiroi.ui.component.exception.PositionOccupiedException

class ContainerHandle(private val container: Container) {
    operator fun set(index: Int, component: Component) {
        if (!attemptSet(index, component)) {
            throw PositionOccupiedException(index)
        }
    }

    fun attemptSet(index: Int, component: Component): Boolean {
        if (container.contains(index)) {
            return false
        }
        container.components[index] = component
        return true
    }

    operator fun set(x: Int, y: Int, component: Component) {
        this[container.indexOf(x, y)] = component
    }

    fun attemptSet(x: Int, y: Int, component: Component): Boolean {
        return attemptSet(container.indexOf(x, y), component)
    }
}


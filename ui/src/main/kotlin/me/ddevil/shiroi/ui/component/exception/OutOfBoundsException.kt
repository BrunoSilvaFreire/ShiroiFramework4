package me.ddevil.shiroi.ui.component.exception

import me.ddevil.shiroi.ui.component.AreaComponent
import me.ddevil.util.math.vector.Vector2i

/**
 * Thrown when an operation is attempted to be executed out of the specified [component]'s area.
 */
class OutOfBoundsException(
        val position: Vector2i,
        val component: AreaComponent
) : RuntimeException() {

}
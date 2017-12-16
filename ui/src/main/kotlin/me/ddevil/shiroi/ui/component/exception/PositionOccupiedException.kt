package me.ddevil.shiroi.ui.component.exception

/**
 * Thrown when a component is attempted to be placed in the same position where there is already a component
 * in a [me.ddevil.shiroi.ui.component.Container]
 */
class PositionOccupiedException(val index: Int) : RuntimeException() {

}
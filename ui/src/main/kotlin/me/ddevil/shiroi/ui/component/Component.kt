package me.ddevil.shiroi.ui.component

abstract class Component {
    abstract fun placeInto(handle: ContainerHandle, initialIndex: Int)
    abstract fun render(handle: DrawingHandle, normalizedInitialIndex: Int)
}

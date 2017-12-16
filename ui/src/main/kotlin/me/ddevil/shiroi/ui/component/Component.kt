package me.ddevil.shiroi.ui.component

abstract class Component {
    internal abstract fun placeInto(handle: ContainerHandle, initialIndex: Int)
    //abstract fun render(normalizedInitialIndex: Int)
}

package me.ddevil.shiroi.ui.component

abstract class SlotComponent : Component() {
    override fun placeInto(handle: ContainerHandle, initialIndex: Int) {
        handle[initialIndex] = this
    }

}
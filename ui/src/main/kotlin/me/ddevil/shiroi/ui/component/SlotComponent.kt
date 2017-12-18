package me.ddevil.shiroi.ui.component

abstract class SlotComponent(
        val display: SlotDisplay
) : Component() {
    override fun render(handle: DrawingHandle, normalizedInitialIndex: Int) {
        handle[normalizedInitialIndex] = display.render()
    }

    override fun placeInto(handle: ContainerHandle, initialIndex: Int) {
        handle[initialIndex] = this
    }

}



package me.ddevil.shiroi.ui.component

import me.ddevil.shiroi.ui.openMenu
import org.bukkit.entity.Player

class Button : SlotComponent, ClickableComponent {
    companion object {
        fun redirectButton(slotDisplay: SlotDisplay, other: Menu): Button {
            return Button(slotDisplay, { _, _, p ->
                p.openMenu(other)
                return@Button true
            })
        }
    }

    constructor(display: SlotDisplay, vararg initialListeners: ClickListener) : super(display) {
        for (listener in initialListeners) {
            addListener(listener)
        }
    }

    constructor(display: SlotDisplay, vararg initialListeners: (Int, Component, Player) -> Boolean) : super(display) {
        for (listener in initialListeners) {
            addListener(object : ClickListener {
                override fun onClick(normalizedClickedPosition: Int, holder: Container, player: Player): Boolean {
                    return listener(normalizedClickedPosition, holder, player)
                }
            })
        }
    }

    private val listeners = HashSet<ClickListener>()

    override fun submit(normalizedClickedPosition: Int, holder: Container, player: Player) {
        for (listener in listeners) {
            if (listener.onClick(normalizedClickedPosition, holder, player)) {
                break
            }
        }
    }

    override fun addListener(clickListener: ClickListener) {
        listeners += clickListener
    }

    override fun removeListener(clickListener: ClickListener) {
        listeners -= clickListener
    }

}
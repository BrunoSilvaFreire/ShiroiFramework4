package me.ddevil.shiroi.ui.component

import org.bukkit.entity.Player

interface ClickableComponent {
    fun submit(normalizedClickedPosition: Int, holder: Container, player: Player)
    fun addListener(clickListener: ClickListener)
    fun removeListener(clickListener: ClickListener)
}
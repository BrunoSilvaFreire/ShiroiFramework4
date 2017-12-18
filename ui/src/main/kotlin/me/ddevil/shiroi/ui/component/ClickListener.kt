package me.ddevil.shiroi.ui.component

import org.bukkit.entity.Player

interface ClickListener {
    fun onClick(normalizedClickedPosition: Int, holder: Container, player: Player): Boolean
}
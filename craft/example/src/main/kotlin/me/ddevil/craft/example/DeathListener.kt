package me.ddevil.craft.example

import me.ddevil.shiroi.craft.locale.sendMessage
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent

class DeathListener(
        private val plugin: ExamplePlugin
) : Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    fun onEntityKilled(event: EntityDeathEvent) {
        val entity = event.entity
        val killer = entity.killer ?: return
        killer.sendMessage(ExampleLangs.entityKilled, plugin, Pair("name", entity.customName))
    }
}
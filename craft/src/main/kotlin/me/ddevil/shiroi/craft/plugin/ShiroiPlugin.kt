package me.ddevil.shiroi.craft.plugin

import me.ddevil.shiroi.craft.config.ConfigManager
import me.ddevil.shiroi.craft.locale.LocaleManager
import me.ddevil.shiroi.design.ColorDesign
import org.bukkit.Bukkit
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

abstract class ShiroiPlugin : JavaPlugin() {
    lateinit var configManager: ConfigManager
        private set
    lateinit var localeManager: LocaleManager
        private set
    lateinit var colorDesign: ColorDesign
    final override fun onEnable() {
        onInit()
    }

    open fun onInit() {}

    fun addListener(listener: Listener) {
        Bukkit.getPluginManager().registerEvents(listener, this)
    }
}
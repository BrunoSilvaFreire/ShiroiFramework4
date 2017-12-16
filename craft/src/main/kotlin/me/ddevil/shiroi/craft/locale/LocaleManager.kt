package me.ddevil.shiroi.craft.locale

import me.ddevil.shiroi.craft.config.ConfigSource
import me.ddevil.shiroi.craft.plugin.ShiroiPlugin
import org.bukkit.entity.Player

class LocaleManager(
        private val plugin: ShiroiPlugin,
        val messagePrefixLang: Lang,
        val messageSeparatorLang: Lang
) {
    val messagePrefix = getLocale(messagePrefixLang)
    val messageSeparator = getLocale(messageSeparatorLang)

    fun getLocaleAsMessage(lang: Lang): String {
        val raw = getLocale(lang)
        return messagePrefix + messageSeparator + raw
    }

    fun sendMessage(raw: String, player: Player) {
        val msg =messagePrefix + messageSeparator + raw
        player.sendMessage(msg)
    }

    fun getLocale(source: ConfigSource, path: String): String? {
        return plugin.configManager.getValue(path, source)
    }

    fun getLocale(lang: Lang): String {
        return plugin.configManager.getValue(lang)
    }
}
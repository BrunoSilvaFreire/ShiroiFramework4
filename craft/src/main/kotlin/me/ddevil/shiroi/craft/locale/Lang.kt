package me.ddevil.shiroi.craft.locale

import me.ddevil.shiroi.craft.config.ConfigSource
import me.ddevil.shiroi.craft.config.ConfigValue
import me.ddevil.shiroi.craft.plugin.ShiroiPlugin
import org.bukkit.entity.Player

class Lang(
        path: String,
        defaultValue: String,
        source: ConfigSource
) : ConfigValue<String>(path, defaultValue, source) {
    fun render(manager: LocaleManager, vararg variables: Pair<String, String>): String {
        var string = manager.getLocale(this)
        for (variable in variables) {
            string = string.replace(variable.first, variable.second)
        }
        return string
    }

    fun sendTo(target: Player, sender: ShiroiPlugin, vararg variables: Pair<String, String>) {
        val manager = sender.localeManager
        val string = render(manager, *variables)
        manager.sendMessage(string, target)
    }
}

fun Player.sendMessage(lang: Lang, plugin: ShiroiPlugin, vararg variables: Pair<String, String>) {
    lang.sendTo(this, plugin, *variables)
}
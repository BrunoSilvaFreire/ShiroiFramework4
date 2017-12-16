package me.ddevil.craft.example

import me.ddevil.shiroi.craft.config.ConfigSource
import me.ddevil.shiroi.craft.locale.Lang

object ExampleLangs {
    val entityKilled = Lang("events.entityKilled", "You've killed {name}", ExampleSources.localeSource)
}

object ExampleSources {
    val localeSource = ConfigSource("locale")
}
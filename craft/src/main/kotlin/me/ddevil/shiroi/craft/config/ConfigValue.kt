package me.ddevil.shiroi.craft.config

open class ConfigValue<N>(
        val path: String,
        val defaultValue: N,
        val source: ConfigSource
)
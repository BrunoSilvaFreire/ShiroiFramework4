package me.ddevil.shiroi.craft.config

abstract class ConfigManager {
    abstract fun <N> getValue(path: String, source: ConfigSource, expectedType: Class<N>): N?

    inline fun <reified N> getValue(path: String, source: ConfigSource): N? {
        return getValue(path, source, N::class.java)
    }

    inline fun <reified N> getValue(value: ConfigValue<N>): N {
        return getValue(value.path, value.source, N::class.java) ?: saveDefault(value)
    }

    fun <N> saveDefault(value: ConfigValue<N>): N {
        val default = value.defaultValue
        saveValue(default, value.path)
        return default
    }

    abstract fun <N> saveValue(default: N, path: String)
}


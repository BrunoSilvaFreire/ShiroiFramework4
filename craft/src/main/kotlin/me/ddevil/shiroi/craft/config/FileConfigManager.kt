package me.ddevil.shiroi.craft.config

class FileConfigManager : ConfigManager() {
    override fun <N> saveValue(default: N, path: String) {
        TODO("not implemented")
    }

    override fun <N> getValue(path: String, source: ConfigSource, expectedType: Class<N>): N? {
        TODO("not implemented")
    }

}
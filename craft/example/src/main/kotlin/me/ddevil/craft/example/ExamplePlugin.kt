package me.ddevil.craft.example

import me.ddevil.shiroi.craft.plugin.ShiroiPlugin

class ExamplePlugin : ShiroiPlugin() {

    override fun onInit() {
        addListener(DeathListener(this))
    }
}


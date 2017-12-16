package me.ddevil.ui.test

import me.ddevil.shiroi.ui.component.Button
import me.ddevil.shiroi.ui.component.Menu
import org.junit.Test

class UsabilityTest {
    @Test
    fun createMenu() {
        val menu = Menu(6)
        menu[0] = Button({ _, _ ->
            println("I've been clicked!")
            return@Button false
        })
    }
}
package me.ddevil.shiroi.ui.component

class Button : SlotComponent, ClickableComponent {
    constructor(vararg initialListeners: ClickListener) : super() {
        for (listener in initialListeners) {
            addListener(listener)
        }
    }

    constructor(vararg initialListeners: (Int, Component) -> Boolean) : super() {
        for (listener in initialListeners) {
            addListener(object : ClickListener {
                override fun onClick(normalizedClickedPosition: Int, holder: Container): Boolean {
                    return listener(normalizedClickedPosition, holder)
                }
            })
        }
    }

    private val listeners = HashSet<ClickListener>()

    override fun submit(normalizedClickedPosition: Int, holder: Container) {
        for (listener in listeners) {
            if (listener.onClick(normalizedClickedPosition, holder)){
                break
            }
        }
    }

    override fun addListener(clickListener: ClickListener) {
        listeners += clickListener
    }

    override fun removeListener(clickListener: ClickListener) {
        listeners -= clickListener
    }

}
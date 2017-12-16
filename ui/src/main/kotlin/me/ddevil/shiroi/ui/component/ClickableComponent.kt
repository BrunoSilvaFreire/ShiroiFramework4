package me.ddevil.shiroi.ui.component

interface ClickableComponent {
    fun submit(normalizedClickedPosition: Int, holder: Container)
    fun addListener(clickListener: ClickListener)
    fun removeListener(clickListener: ClickListener)
}


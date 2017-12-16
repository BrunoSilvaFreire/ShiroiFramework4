package me.ddevil.shiroi.ui.component

interface ClickListener {
    fun onClick(normalizedClickedPosition: Int, holder: Container): Boolean
}
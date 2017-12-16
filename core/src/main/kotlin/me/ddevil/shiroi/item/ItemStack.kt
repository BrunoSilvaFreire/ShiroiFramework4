package me.ddevil.shiroi.item

class ItemStack(
        material: ItemMaterial,
        val amount: Int
) : Item(material)
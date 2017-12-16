package me.ddevil.shiroi.ui.component

import me.ddevil.shiroi.ui.component.exception.OutOfBoundsException
import me.ddevil.util.math.vector.Vector2i

abstract class AreaComponent(
        val width: Int,
        val height: Int
) : Component() {
    override fun placeInto(handle: ContainerHandle, initialIndex: Int) {
        for (x in 0..width) {
            for (y in 0..height) {
                handle[x, y] = this
            }
        }
    }

    val size: Vector2i
        get() {
            return Vector2i(width, height)
        }

    fun isOutOfBounds(position: Vector2i): Boolean {
        return position.x >= width || position.y >= height
    }

    fun isOutOfBounds(x: Int, y: Int): Boolean {
        return x >= width || y >= height
    }

    fun indexOf(position: Vector2i): Int {
        checkOutOfBounds(position)
        return indexOfUnsafe(position)
    }

    fun indexOfUnsafe(position: Vector2i): Int {
        return indexOfUnsafe(position.x, position.y)
    }

    fun indexOf(x: Int, y: Int): Int {
        checkOutOfBounds(x, y)
        return indexOfUnsafe(x, y)
    }

    fun indexOfUnsafe(x: Int, y: Int): Int {
        return y * width + x
    }

    protected fun checkOutOfBounds(position: Vector2i) {
        if (isOutOfBounds(position)) {
            throw OutOfBoundsException(position, this)
        }
    }

    protected fun checkOutOfBounds(x: Int, y: Int) {
        if (isOutOfBounds(x, y)) {
            throw OutOfBoundsException(Vector2i(x, y), this)
        }
    }
}
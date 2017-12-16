package me.ddevil.shiroi.fx

import me.ddevil.util.math.vector.Vector3f

abstract class Geometry {
    abstract fun render(): Iterable<Vector3f>
}
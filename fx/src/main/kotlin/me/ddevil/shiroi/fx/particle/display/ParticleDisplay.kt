package me.ddevil.shiroi.fx.particle.display

/**
 * Defines how a particle will be sent
 */
abstract class ParticleDisplay {
    abstract fun display(x: Float, y: Float, z: Float)
}
package me.ddevil.shiroi.fx.particle

import me.ddevil.shiroi.fx.Geometry
import me.ddevil.shiroi.fx.particle.display.ParticleDisplay
import me.ddevil.util.math.quaternion.Quaternion
import me.ddevil.util.math.vector.Vector3f
import org.bukkit.World
import org.bukkit.entity.Player

data class ParticleFX(
        val geometry: Geometry,
        val display: ParticleDisplay
) {
    @JvmOverloads
    fun display(world: World, center: Vector3f, rotation: Quaternion = Quaternion.identity) {
        display(world.players, center, rotation)
    }

    @JvmOverloads
    fun display(players: Iterable<Player>, center: Vector3f, rotation: Quaternion = Quaternion.identity) {
        for (player in players) {
            display(player, center, rotation)
        }
    }

    @JvmOverloads
    fun display(player: Player, center: Vector3f, rotation: Quaternion = Quaternion.identity) {
    }
}
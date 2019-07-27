package attack

import player.Player
import Type

open class Attack(
    val name: String,
    val type: Type,
    val accuracy: Int,
    var pp: Int,
    val priority: Int,
    val effect: ((attacker: Player, defender: Player) -> Unit)? = null,
    val power: Int = 0
) {

    override fun toString(): String {
        return name
    }

    val canBeUsed: Boolean get() {
        return pp > 0
    }
}
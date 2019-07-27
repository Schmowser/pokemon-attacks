package attack

import AttackName
import player.Player

class AttackFactory {

    private val painSplitEffect = fun(attacker: Player, defender: Player) {
        val averageHealth: Int = (attacker.health + defender.health) / 2
        attacker.health = averageHealth
        defender.health = averageHealth
    }

    fun create(attackName: AttackName): Attack {

        return when (attackName) {
            AttackName.TACKLE -> PhysicalAttack(
                name = AttackName.TACKLE.en,
                type = Type.NORMAL,
                power = 40,
                pp = 35
            )
            AttackName.QUICKATTACK -> PhysicalAttack(
                name = AttackName.QUICKATTACK.en,
                type = Type.NORMAL,
                power = 40,
                pp = 30,
                priority = 1
            )
            AttackName.PAINSPLIT -> StatusAttack(
                name = AttackName.PAINSPLIT.en,
                type = Type.NORMAL,
                pp = 20,
                effect = painSplitEffect
            )
        }

    }

}
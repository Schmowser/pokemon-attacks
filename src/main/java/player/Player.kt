package player

import StatusEffect
import Type
import attack.Attack
import attack.PhysicalAttack
import kotlin.math.roundToInt

open class Player(
    val name: String,
    var health: Int = 250,
    val types: Type,
    var roster: List<Attack> = emptyList(),
    var status: StatusEffect? = null
) {

    override fun toString(): String {
        return name
    }

    val isDefeated: Boolean get() {
        return health <= 0
    }

    fun attacks(opponent: Player, attack: Attack) {

        // Check if StatusEffect prevents execution of attack
        when (this.status) {
            StatusEffect.PARALYZED, StatusEffect.FROZEN, StatusEffect.ASLEEP, StatusEffect.INFATUATED, StatusEffect.FLINCHING -> {
                if ((0..2).random() == 0) this.health -= 10 // TODO: Make this skip the attack.Attack and differentiate between all StatusEffects
            }
            StatusEffect.POISONED -> this.health -= (1/8 * 250) // TODO: Move to end of attack.Attack
            StatusEffect.BURNED -> this.health -= (1/16 * 250) // TODO: Move to end of attack.Attack

            StatusEffect.LEECHSEED -> {
                this.health -= 10
                opponent.health += 10
            }
            StatusEffect.CONFUSED -> {
                println("Attacker is confused.")
                if ((0..2).random() == 0) {
                    this.health -= 40
                    println("It hurt itself in confusion.")
                    // TODO: Return something or jump to end of function
                }
            }
        }

        // Accuracy
        if ((0..100).random() <= attack.accuracy) {

            // Calculate Multiplier from StatusEffect
            val multiplierStatusEffect: Double = if (
                this.status?.equals(StatusEffect.BURNED) == true
                || attack is PhysicalAttack
            ) {
                0.5
            } else {
                1.0
            }

            // Calculate Multiplier from Type
            val multiplier: Double = attack.type
                .isEffectiveAgainst(opponent.types)

            // Calculate Multipler from Critical Hit

            // Reduce opponent's health by attack total power
            opponent.health = (opponent.health - attack.power * multiplier * multiplierStatusEffect).roundToInt()

            // Commit attack's effect
            attack.effect?.invoke(this, opponent)

            // Decrement attack's power points
            attack.pp--

        } else {
            println("attack.Attack missed!")
        }
    }
}
package attack

import player.Player
import Type
import StatusEffect

class StatusAttack (name: String,
                    type: Type,
                    accuracy: Int = 100,
                    pp: Int,
                    priority: Int = 0,
                    effect: ((attacker: Player, defender: Player) -> Unit),
                    val status: StatusEffect ?= null) : Attack(name, type, accuracy, pp, priority, effect)
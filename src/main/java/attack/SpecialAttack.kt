package attack

import Type

class SpecialAttack(name: String,
                    type: Type,
                    power: Int,
                    accuracy: Int,
                    pp: Int,
                    priority: Int = 0) : Attack(name, type, accuracy, pp, priority, power = power)
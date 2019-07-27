package attack

import Type

class PhysicalAttack(name: String,
                     type: Type,
                     power: Int,
                     accuracy: Int = 100,
                     pp: Int,
                     priority: Int = 0) : Attack(name, type, accuracy, pp, priority, power = power)
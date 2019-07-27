enum class Type {
    NORMAL, FIRE, FIGHTING,
    WATER, FLYING, GRASS,
    POISON, ELECTRIC, GROUND,
    PSYCHIC, ROCK, ICE,
    BUG, DRAGON, GHOST,
    DARK, STEEL, FAIRY;

    fun isEffectiveAgainst(thatType: Type): Double {

        when (this) {
            NORMAL -> {
                return when (thatType) {
                    ROCK, STEEL -> 0.5
                    GHOST -> 0.0
                    else -> 1.0
                }
            }
            FIGHTING -> {
                return when (thatType) {
                    NORMAL, ROCK, STEEL, ICE, DARK -> 2.0
                    FLYING, POISON, BUG, PSYCHIC, FAIRY -> 0.5
                    GHOST -> 0.0
                    else -> 1.0
                }
            }
            FLYING -> {
                return when (thatType) {
                    FIGHTING, BUG, GRASS -> 2.0
                    ROCK, STEEL, ELECTRIC -> 0.5
                    else -> 1.0
                }
            }
            POISON -> {
                return when (thatType) {
                    GRASS, FAIRY -> 2.0
                    POISON, GROUND, ROCK, GHOST -> 0.5
                    STEEL -> 0.0
                    else -> 1.0
                }
            }
            GROUND -> {
                return when (thatType) {
                    POISON, ROCK, STEEL, FIRE, ELECTRIC -> 2.0
                    BUG, GRASS -> 0.5
                    FLYING -> 0.0
                    else -> 1.0
                }
            }
            ROCK -> {
                return when (thatType) {
                    FLYING, BUG, FIRE, ICE -> 2.0
                    FIGHTING, GROUND, STEEL -> 0.5
                    else -> 1.0
                }
            }
            BUG -> {
                return when (thatType) {
                    GRASS, PSYCHIC, DARK -> 2.0
                    FIGHTING, FLYING, POISON, GHOST, STEEL, FIRE, BUG -> 0.5
                    else -> 1.0
                }
            }
            GHOST -> {
                return when (thatType) {
                    GHOST, PSYCHIC -> 2.0
                    DARK -> 0.5
                    NORMAL -> 0.0
                    else -> 1.0
                }
            }
            STEEL -> {
                return when (thatType) {
                    ROCK, ICE, FAIRY -> 2.0
                    STEEL, FIRE, WATER, ELECTRIC -> 0.5
                    else -> 1.0
                }
            }
            FIRE -> {
                return when (thatType) {
                    BUG, STEEL, GRASS, ICE -> 2.0
                    ROCK, FIRE, WATER, DRAGON -> 0.5
                    else -> 1.0
                }
            }
            WATER -> {
                return when (thatType) {
                    GROUND, ROCK, FIRE -> 2.0
                    WATER, GRASS, DRAGON -> 0.5
                    else -> 1.0
                }
            }
            GRASS -> {
                return when (thatType) {
                    GROUND, ROCK, WATER -> 2.0
                    FLYING, POISON, BUG, STEEL, FIRE, GRASS, DRAGON -> 0.5
                    else -> 1.0
                }
            }
            ELECTRIC -> {
                return when (thatType) {
                    FLYING, WATER -> 2.0
                    GRASS, ELECTRIC, DRAGON -> 0.5
                    GROUND -> 0.0
                    else -> 1.0
                }
            }
            PSYCHIC -> {
                return when (thatType) {
                    FIGHTING, POISON -> 2.0
                    STEEL, PSYCHIC -> 0.5
                    DARK -> 0.0
                    else -> 1.0
                }
            }
            ICE -> {
                return when (thatType) {
                    FLYING, GROUND, GRASS, DRAGON -> 2.0
                    STEEL, FIRE, WATER, ICE -> 0.5
                    else -> 1.0
                }
            }
            DRAGON -> {
                return when (thatType) {
                    DRAGON -> 2.0
                    STEEL -> 0.5
                    FAIRY -> 0.0
                    else -> 1.0
                }
            }
            DARK -> {
                return when (thatType) {
                    GHOST, PSYCHIC -> 2.0
                    FIGHTING, DARK, FAIRY -> 0.5
                    else -> 1.0
                }
            }
            FAIRY -> {
                return when (thatType) {
                    FIGHTING, DRAGON, DARK -> 2.0
                    POISON, STEEL, FIRE -> 0.5
                    else -> 1.0
                }
            }

        }
    }
}
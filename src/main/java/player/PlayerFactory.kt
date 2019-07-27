package player

import Type
import attack.Attack

class PlayerFactory {

    fun create(name: String, type: Type, vararg moves: Attack) : Player {

        val player = Player(
            name = name,
            types = type
        )

        val playerMoves = ArrayList<Attack>()
        for (move in moves) {
            playerMoves.add(move)
        }
        player.roster = playerMoves

        return player

    }

}
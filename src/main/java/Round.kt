import attack.Attack
import player.Player

class Round(
    val number: Int,
    private val moves: List<Attack> = emptyList(),  // TODO: Use Pairs
    private val players: List<Player>
) {
    fun execute() {
        if (moves[0].priority > moves[1].priority) {
            print(players[0].name)
            print(" uses ")
            println(moves[0].name)
            players[0].attacks(players[1], moves[0])

            print(players[1].name)
            print(" uses ")
            println(moves[1].name)
            players[1].attacks(players[0], moves[1])
        } else {
            print(players[1].name)
            print(" uses ")
            println(moves[1].name)
            players[1].attacks(players[0], moves[1])

            print(players[0].name)
            print(" uses ")
            println(moves[0].name)
            players[0].attacks(players[1], moves[0])
        }

        for (player in players) {
            print(player.name)
            print("'s health is ")
            print(player.health)
            print(". ")
        }

        println("")
    }
}
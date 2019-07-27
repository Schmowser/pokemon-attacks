import attack.Attack
import attack.AttackFactory
import player.PlayerFactory

fun main() {

    val attackFactory = AttackFactory()
    val playerFactory = PlayerFactory()

    val tackle = attackFactory.create(AttackName.TACKLE)
    val painSplit = attackFactory.create(AttackName.PAINSPLIT)
    val quickAttack = attackFactory.create(AttackName.QUICKATTACK)

    val player1 = playerFactory.create("Ash", Type.NORMAL, tackle, quickAttack)
    val player2 = playerFactory.create("Gary", Type.NORMAL, painSplit)

    val players = listOf(player1, player2)

    println("Pokémon Attacks!")
    println("================")

    for (player in players) {

        print(player.name)
        println("'s moves:")
        print("| ")

        for (move in player.roster) {
            print(player.roster.indexOf(move))
            print(" : ")
            print(move.name)
            print(" | ")
        }

        println("")

    }

    var roundNumber = 0
    var attackIndex: Int
    val movesOfCurrentRound: MutableList<Attack> = mutableListOf()
    var chosenMove: Attack

    while (!player1.isDefeated || !player2.isDefeated) {

        for (player in players) {

            print("It's ")
            print(player.name)
            println(" turn. Please provide index of move you want to play: ")

            while (true) {
                val inputString: String? = readLine()

                try {
                    attackIndex = inputString?.toInt()!!
                    chosenMove = player.roster[attackIndex]
                    movesOfCurrentRound.add(chosenMove)
                    break
                } catch (ibe: IndexOutOfBoundsException) {
                    println("Please specify an Integer from 0 to 3.")
                    continue
                } catch (nfe: NumberFormatException) {
                    println("You entered a non-integer. Please try again.")
                    continue
                }
            }

        }

        val round = Round(roundNumber, moves = movesOfCurrentRound, players = players)
        round.execute()

        movesOfCurrentRound.clear()
        roundNumber++

    }




}
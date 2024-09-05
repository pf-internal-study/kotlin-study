package internal.study.kotlin.son.day4

class Game(private val players: List<Player>, private val numberOfRounds: Int) {

    fun play(): Player {
        val finalScores = players.associateWith { 0 }.toMutableMap()

        // 반복문
        repeat(numberOfRounds) {
            val round = Round(players)
            val roundWinner = round.play()
            finalScores[roundWinner] = finalScores[roundWinner]!! + roundWinner.score

            println("Round ${it + 1}: ${roundWinner.name} wins with ${roundWinner.score} points")
        }

        val topPlayers = finalScores
            .filterValues { it == finalScores.values.maxOrNull() }
            .keys
            .toList()

        // 이렇게도 리턴가능 오호...
        return if (topPlayers.size == 1) {
            topPlayers.first()
        } else {
            playRematch(topPlayers)
        }

    }
    private fun playRematch(tiedPlayers: List<Player>): Player {
        if (tiedPlayers.size == 1) {
            return tiedPlayers.first()
        }

        val rematchRound = Round(tiedPlayers.map { Player(it.name) })
        val roundWinner = rematchRound.play()
        val remainingTiedPlayers = tiedPlayers.filter { it.name == roundWinner.name }

        // 재귀 호출
        return playRematch(remainingTiedPlayers)
    }
}
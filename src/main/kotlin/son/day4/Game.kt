package internal.study.kotlin.son.day4

class Game(private val players: List<Player>, private val numberOfRounds: Int) {

    fun play(): Player {
        val finalScores = players.associateWith { 0 }.toMutableMap()

        // 각 라운드 진행
        repeat(numberOfRounds) { roundIndex ->
            val round = Round(players.map { it.rollNewDice() })
            val roundWinner = round.play()
            finalScores[roundWinner] = finalScores.getOrDefault(roundWinner, 0) + 1

            println("Round ${roundIndex + 1}: ${roundWinner.name} wins with ${roundWinner.score} points")
        }

        // 동점자 확인
        val topPlayers = finalScores.filterValues { it == finalScores.values.maxOrNull() }.keys.toList()

        return if (topPlayers.size == 1) {
            topPlayers.first()
        } else {
            rematch(finalScores, topPlayers) // 동점자 처리
        }
    }

    private fun rematch(finalScores: MutableMap<Player, Int>, tiedPlayers: List<Player>): Player {
        // 재경기: 동점자가 아닌 플레이어들은 0점으로 설정
        finalScores.keys.forEach { player ->
            if (player !in tiedPlayers) {
                finalScores[player] = 0
            }
        }

        // 동점자만 다시 주사위를 굴림
        val newRound = Round(tiedPlayers.map { it.rollNewDice() })
        val roundWinner = newRound.play()

        // 동점자 중 승자의 점수만 갱신
        finalScores[roundWinner] = roundWinner.score

        // 동점자 재경기 결과 확인
        val newTiedPlayers = finalScores.filterValues { it == finalScores.values.maxOrNull() }.keys.toList()

        println("Rematch: ${roundWinner.name} wins with ${roundWinner.score} points")

        return if (newTiedPlayers.size == 1) {
            newTiedPlayers.first() // 최종 승자 결정
        } else {
            rematch(finalScores, newTiedPlayers) // 재경기 반복
        }
    }
}

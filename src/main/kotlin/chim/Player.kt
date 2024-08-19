package internal.study.kotlin.chim

import java.util.Random

data class Player(
    val name: String,
    val nickname: String = "anonymous@${Random().nextInt(1, 100)}"
)

package internal.study.kotlin.min

import java.util.*

data class PlayerMin(
    val name: String,
    val nickname: String = generateRandomNickname()
) {
    companion object {
        fun generateRandomNickname(): String {
            val randomValue = (1..100).random()
            return "anonymous@$randomValue"
        }
    }
}

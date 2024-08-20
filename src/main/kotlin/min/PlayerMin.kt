package internal.study.kotlin.min

import java.util.*

data class PlayerMin(
    val name: String,
    val nickname: String = generateRandomNickname()
) {
    companion object {
        fun generateRandomNickname(): String {
            val randomValue = Random().nextInt(1, 100)
            return "anonymous@$randomValue"
        }
    }
}

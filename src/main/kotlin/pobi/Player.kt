package internal.study.kotlin.pobi

data class Player (
    val name: String,
    val nickname: String = "anonymous@" + (1..100).random()
)

/**
 * 생성자 호출 순서
 * 1. 주 생성자
 * 2. init 블록
 * 3. 보조 생성자
 */

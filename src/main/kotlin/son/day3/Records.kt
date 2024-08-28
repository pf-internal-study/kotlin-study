package internal.study.kotlin.son.day3

//라운드 > 기록지 > 플레이어
/*
기록지(records)에는 플레이어마다 해당 라운드에 던진 5개 주사위의 눈금 결과가 기록된다.
라운드가 가지는 기록지는 1개이며, 기록지 1개에 여러 플레이어의 기록이 담겨있다.
라운드가 생성될 때 기록지는 비어있다. (empty)
*/

class Records(private val player: Player) {
    private val records: List<Int> = emptyList()

    fun record(eyes: Int) {
        require(eyes in 1..6) { "주사위의 눈금은 1~6 사이여야 합니다." }
        require(records.size < 5) { "주사위는 5개만 던질 수 있습니다." }
        records.toMutableList().add(eyes)
    }
}
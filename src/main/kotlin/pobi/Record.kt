package internal.study.kotlin.pobi

class Record(private var totalPoint: Int, private var player: Player?) {

    fun getTotalPoint() : Int {
        return totalPoint
    }

    fun getPlayer() : Player {
        return player!!
    }
}

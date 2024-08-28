package internal.study.kotlin.pobi

class Round(val id: Int) {
    private var _records: MutableList<Record> = mutableListOf()
    var roundWinner: Player? = null

    fun setRoundWinner() {
        roundWinner = _records.maxByOrNull { it.getTotalDices() }?.getPlayer()!!;
    }

    fun getRecords(): List<Record> {
        return _records.toList();
    }

}

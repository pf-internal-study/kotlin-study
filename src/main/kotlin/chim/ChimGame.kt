package internal.study.kotlin.chim

fun main() {
    val game = Game()
    listOf(
        Player("성현석", "침"),
        Player("손민기", "손"),
        Player("남상이", "생이"),
        Player("이민열", "민"),
        Player("이재근", "샤이"),
        Player("유진탁", "포비"),
    ).forEach { game.join(it) }

    game.start()
    game.print()

    game.printWinners()
}

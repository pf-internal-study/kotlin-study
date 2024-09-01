package pobi

import internal.study.kotlin.pobi.Game
import internal.study.kotlin.pobi.Player
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class GameTest : StringSpec({
    "게임에는 플레이어가 참가할수 있다." {
        val actual = Game()
        actual.joinPlayer(Player("포비", "곰은 사람을 찢어"))
        actual.players shouldHaveSize  1
    }

    "중복 플레이어가 참가할수 있다." {
        val actual = Game()
        actual.joinPlayer(Player("포비", "곰은 사람을 잔인하게 찢어"))
        val exception = shouldThrow<IllegalStateException> {
            actual.joinPlayer(Player("포비", "곰은 사람을 잔인하게 찢어"))
        }
        exception.message shouldBe "동일한 플레이어는 참가할수 없습니다."
    }

})

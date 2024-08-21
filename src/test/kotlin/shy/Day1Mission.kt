package shy

import internal.study.kotlin.shy.Player
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.equals.shouldNotBeEqual
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.string.shouldContain

/**
 * 함수 테스트시 유용한 테스트코드 (FunSpec)
 */
class Day1Mission1: FunSpec({
    test("플레이어는 이름과 닉네임을 가진다.") {
        val player = Player("이재근", "샤이");

        player.name shouldBe "이재근"
        player.nickName shouldBe "샤이"
    }

    test("닉네임이 없는경우 기본 닉네임을 할당한다.") {
        val player = Player("이재근", null);

        player.name shouldBe "이재근"
        player.nickName shouldContain "anonymous@"
    }

    test("이름과 닉네임이 같은 경우 동일한 플레이어이다.") {
        val player1 = Player("이재근", "shy")
        val player2 = Player("이재근", "shy")

        player1 shouldBe player2
    }
})

/**
 * BDD 스타일의 테스트코드 (BehaviorSpec)
 */
class Day1Mission2: BehaviorSpec({

    Given("플레이어는") {
        When("정상적으로 생성되면") {
            val player = Player("이재근", "샤이");
            Then("이름과 닉네임을 가진다.") {
                player.name shouldBe "이재근"
                player.nickName shouldBe "샤이"
            }
        }

        When("닉네임이 없다면") {
            val player = Player("이재근", null);
            Then("기본 닉네임을 할당한다.") {
                player.name shouldBe "이재근"
                player.nickName shouldContain "anonymous@"
            }
        }

        When("이름과 닉네임 같다면") {
            val player1 = Player("이재근", "shy")
            val player2 = Player("이재근", "shy")
            Then("동일한 플레이어이다.") {
                player1 shouldBe player2
            }
        }

        When("이름과 닉네임이 같지 않다면") {
            val player1 = Player("이재근", "shy")
            val player2 = Player("이재근", "superShy")
            Then("동일한 플레이어가 아니다.") {
                player1 shouldNotBeEqual player2
            }
        }

    }
})

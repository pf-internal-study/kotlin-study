import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class TestSample : StringSpec({

    "1+1은 2다" {
        val actual: Int = 1 + 1
        actual shouldBe 2
    }
})
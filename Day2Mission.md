# Day 2
플레이어가 사용할 주사위를 만들어보자

## 요구사항

### 주사위 (Dice)
- 주사위는 주사위 눈(eyes)을 가진다.
    - 단, 주사위 눈은 주사위 생성 시점엔 값을 가지지 않는다.
- 주사위는 주사위를 굴리는 기능(roll)이 있다.
    - 주사위를 굴리면 1~6 사이 숫자를 부여받고, 그 값을 외부로 반환한다.
- 주사위는 주사위를 굴려 나온 값을 볼 수 있는 기능(view)이 있다.
    - 단, 주사위를 굴리기 전엔 볼 수 없다.
```kotlin
// 주사위를 굴려 나온 주사위 눈을 반환
fun roll(): Int
// 사전에 굴려서 나온 주사위 눈을 반환
fun view(): Int
```

### 예외 검증 방법
```kotlin
"예외발생 검증" {
    // shouldThrow 는 함수블럭 실행 후 발생한 예외를 반환한다
    val exception = shouldThrow<Exception> {
        // 검증 코드 작성
    }

    exception.message shouldBe "예외 발생메시지"
}

"정상 처리 검증" {
    // shouldNotThrow 는 함수블럭 실행 후 Unit 을 반환한다
    val exception = shouldNotThrow<Exception> {
        // 검증 코드 작성
    }

    exception shouldBe Unit
}
```

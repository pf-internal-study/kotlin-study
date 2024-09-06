package internal.study.kotlin.son.day4

class Dice {
    companion object {
        fun roll(): DiceEyes = DiceEyes.of((1..6).random())
    }
}
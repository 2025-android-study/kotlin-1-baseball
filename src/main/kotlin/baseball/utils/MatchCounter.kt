package baseball.utils

import baseball.model.MatchCount

object MatchCounter {
    fun getMatchCount(userInputNumArr: List<Int>, randomNumArr: List<Int>): MatchCount {
        var strikeCount = 0
        var ballCount = 0
        userInputNumArr.forEachIndexed { index, num ->
//            println("숫자 비교 - index: $index, userInput: $num, computer: ${randomNumArr[index]}")
            if (userInputNumArr[index] == randomNumArr[index]) strikeCount++
            else if (randomNumArr.contains(num)) ballCount++
        }
        return MatchCount(strikeCount, ballCount)
    }
}
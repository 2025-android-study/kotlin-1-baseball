package baseball.util

class ResultCounter {
    fun countResult(input: List<Int>, answer: List<Int>): Pair<Int, Int> {
        var strike = 0
        var ball = 0

        for (i in input.indices) {
            if(input[i] == answer[i]) strike++
            else if (answer.contains(input[i])) ball++
        }

        return Pair(strike, ball)
    }
}
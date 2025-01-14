package baseball.view

import baseball.consts.OutputConst

class OutputView {
    fun printResult(strike: Int, ball: Int) {
        println(createResult(strike, ball))
    }

    fun printStart() {
        println(OutputConst.GAME_START)
    }

    fun printFinish() {
        println(OutputConst.GAME_FINISHED)
    }

    private fun createResult(strike: Int, ball: Int): String {
        return when {
            strike == 0 && ball == 0 -> OutputConst.NOTHING.s

            ball == 0 -> String.format(OutputConst.STRIKE.s, strike)

            strike == 0 -> String.format(OutputConst.BALL.s, ball)

            else -> String.format(OutputConst.BALL.s, ball) + String.format(OutputConst.STRIKE.s, strike)
        }
    }
}
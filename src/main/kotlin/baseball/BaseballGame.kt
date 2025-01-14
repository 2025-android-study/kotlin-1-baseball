package baseball

import baseball.consts.Rule
import baseball.util.NumberGenerator
import baseball.util.ResultCounter
import baseball.view.InputView
import baseball.view.OutputView

class BaseballGame {
    private val input = InputView()
    private val output = OutputView()
    private val counter = ResultCounter()

    fun run() {
        output.printStart()
        do {
            play()
        } while (input.getRestart() == Rule.RESUME)
    }

    private fun play() {
        val answer = NumberGenerator.generateNumber()
        while(true) {
            val num = input.getNumber()
            val (strike, ball) = counter.countResult(num, answer)
            output.printResult(strike, ball)

            if(strike == Rule.NUM_LENGTH) {
                output.printFinish()
                break
            }
        }
    }


}
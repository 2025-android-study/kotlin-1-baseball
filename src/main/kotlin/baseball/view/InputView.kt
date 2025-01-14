package baseball.view

import baseball.consts.InputConst
import baseball.validation.InputValidator
import camp.nextstep.edu.missionutils.Console

class InputView {
    private val validator = InputValidator()

    fun getNumber(): Int {
        print(InputConst.INPUT_NUMBER)
        val input = Console.readLine()

        // TODO 검증

        return input.toInt()
    }

    fun getRestart(): Int {
        print(InputConst.INPUT_RESTART)
        val input = Console.readLine()

        // TODO 검증

        return input.toInt()
    }
}
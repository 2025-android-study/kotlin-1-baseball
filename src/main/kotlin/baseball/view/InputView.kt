package baseball.view

import baseball.consts.InputConst
import baseball.validation.InputValidator
import camp.nextstep.edu.missionutils.Console

class InputView {
    private val validator = InputValidator()

    fun getNumber(): List<Int> {
        print(InputConst.INPUT_NUMBER)
        val input = Console.readLine()

        validator.validateNum(input)

        return input.map { it.digitToInt() }
    }

    fun getRestart(): Int {
        print(InputConst.INPUT_RESTART)
        val input = Console.readLine()

        validator.validateRestart(input)

        return input.toInt()
    }
}
package baseball.view

import baseball.consts.InputConst
import baseball.util.InputValidator
import camp.nextstep.edu.missionutils.Console

class InputView {
    private val validator = InputValidator()

    fun getNumber(): List<Int> {
        print(InputConst.INPUT_NUMBER.s)
        val input = Console.readLine()

        validator.validateNum(input)

        return input.map { it.digitToInt() }
    }

    fun getRestart(): Int {
        print(InputConst.INPUT_RESTART.s)
        val input = Console.readLine()

        validator.validateRestart(input)

        return input.toInt()
    }
}
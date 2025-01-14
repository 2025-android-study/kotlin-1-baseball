package baseball.util

import baseball.consts.ErrorConst
import baseball.consts.Rule

class InputValidator {
    fun validateNum(input: String) {
        require((isNumber(input))) { ErrorConst.NOT_NUMBER }

        require(input.length == Rule.NUM_LENGTH) { ErrorConst.LENGTH_ERROR }

        require(!input.contains(Rule.ZERO)) { ErrorConst.VALUE_ERROR }

        require(!isDuplicate((input))) { ErrorConst.DUPLICATE_ERROR }
    }


    fun validateRestart(input: String) {
        require((isNumber(input))) { ErrorConst.NOT_NUMBER }

        require(input.toInt() == Rule.RESUME || input.toInt() == Rule.STOP) { ErrorConst.VALUE_ERROR }
    }


    private fun isNumber(input: String): Boolean = input.all { ch -> ch.isDigit() }

    private fun isDuplicate(input: String) = input.length != input.toSet().size
}
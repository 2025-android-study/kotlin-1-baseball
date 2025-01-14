package baseball.utils

import baseball.constants.GAME_DIGIT
import baseball.enums.GameRestartCondition

object InputValidator {
    private lateinit var inputString: String
    val regex = "[1-9]".toRegex()

    fun setUserInput(input: String) {
        inputString = input
    }

    // 유저가 입력한 숫자
    fun checkUserGuessDigitValidation() {
        check(isLengthOK()) { "${GAME_DIGIT}자리 숫자를 입력해야 합니다." }
        check(isAllValidDigit()) { "모든 자리는 숫자여야 합니다." }
        check(isUniqueDigit()) { "각 자리 숫자는 서로 달라야 합니다." }
    }

    // 유저가 입력한 게임 종료 숫자
    fun checkUserGameRestartValidation() {
        try {
            val inputValue = inputString.toInt()
            check(isGameRestartCondition(inputValue)) { "입력값은 ${GameRestartCondition.RESTART.value} 또는 ${GameRestartCondition.EXIT.value}여야 합니다" }
        } catch (e: Exception) {
            throw IllegalArgumentException("입력값은 숫자여야 합니다")
        }
    }

    // 게임 기준 숫자와 사용자 입력 길이 비교
    private fun isLengthOK(): Boolean {
        return inputString.length == GAME_DIGIT
    }

    // 모든 자리가 숫자인지 확인
    private fun isAllValidDigit(): Boolean {
        val charArr = inputString.toCharArray() // 문자열을 한 자씩 저장
        charArr.forEach { char ->
            if (!regex.matches(char.toString())) return false // 유효한 숫자가 아닌 경우 바로 false를 리턴
        }
        return true
    }

    // 각 자리가 유니크한 숫자인지 확인
    private fun isUniqueDigit(): Boolean {
        val originalCharArr = inputString.toCharArray() // 기본
        val duplicationCharRemovedArr = originalCharArr.distinct() // 중복 문자 제거
        return originalCharArr.size == duplicationCharRemovedArr.size
    }

    // 게임 종료 조건에 해당하는 숫자인지 확인
    private fun isGameRestartCondition(value: Int): Boolean {
        return (value == GameRestartCondition.RESTART.value) || (value == GameRestartCondition.EXIT.value)
    }
}
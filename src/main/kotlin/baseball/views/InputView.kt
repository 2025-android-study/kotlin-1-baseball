package baseball.views

import baseball.constants.GAME_START_GUIDE
import baseball.constants.INPUT_GUIDE
import baseball.utils.Converter
import baseball.utils.InputValidator
import camp.nextstep.edu.missionutils.Console

object InputView {
    private var inputValidator = InputValidator

    fun printGameStartGuide() {
        println(GAME_START_GUIDE) // 게임 시작 문구 출력
    }

    // 숫자 입력받기
    fun getUserGuessDigit(): List<Int> {
        print(INPUT_GUIDE) // 입력 문구
        val input = Console.readLine()

        inputValidator.setUserInput(input) // 입력 정보 세팅
        inputValidator.checkIsValidInput() // 유효한 입력인지 확인

        return Converter.convertStringToIntArr(input) // 유효한 입력이라면 숫자 배열로 변환
    }
}
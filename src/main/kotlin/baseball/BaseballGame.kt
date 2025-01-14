package baseball

import baseball.constants.GAME_START_GUIDE
import baseball.constants.INPUT_GUIDE
import baseball.utils.InputValidator
import baseball.utils.RandomNumberGenerator
import camp.nextstep.edu.missionutils.Console

class BaseballGame {

    private var inputValidator = InputValidator

    fun play() {
        println(GAME_START_GUIDE) // 게임 시작 문구 출력
        val randomNum = RandomNumberGenerator.createRandomNumber() // 난수 생성
//        println(randomNum)
        handleUserInput() // 사용자 입력 처리
    }

    private fun handleUserInput() {
        print(INPUT_GUIDE) // 입력 문구
        val input = Console.readLine()
//        println(input)
        inputValidator.setUserInput(input)
        val isValidInput = inputValidator.checkIsValidInput()
//        println("isValidInput: $isValidInput")
    }
}
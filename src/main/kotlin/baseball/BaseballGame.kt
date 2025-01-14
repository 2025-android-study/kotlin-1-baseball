package baseball

import baseball.constants.GAME_DIGIT
import baseball.constants.GAME_START_GUIDE
import baseball.constants.INPUT_GUIDE
import baseball.utils.Converter
import baseball.utils.InputValidator
import baseball.utils.MatchCounter
import baseball.utils.RandomNumberGenerator
import baseball.views.OutputView
import camp.nextstep.edu.missionutils.Console

class BaseballGame {

    private var inputValidator = InputValidator
    private var outputView = OutputView

    val randomNumArr = RandomNumberGenerator.createRandomNumber() // 컴퓨터 숫자
    var userInputNumArr: List<Int> = mutableListOf() // 사용자가 입력한 숫자

    fun play() {
        println(GAME_START_GUIDE) // 게임 시작 문구 출력
        println(randomNumArr)
        while (true) {
            handleUserInput() // 사용자 입력 처리
            val canExit = compareArrData() // 숫자 비교
            if (canExit) return //TODO: 게임 재시작 여부 묻기
        }
    }

    // 컴퓨터 숫자와 사용자 입력 숫자 비교
    private fun compareArrData(): Boolean {
        var matchCount = MatchCounter.getMatchCount(userInputNumArr, randomNumArr)
        // 힌트 텍스트 출력
        outputView.printMatchResult(MatchCounter.getMatchCount(userInputNumArr, randomNumArr))
        // exit 조건 체크
        return matchCount.strikeCount == GAME_DIGIT
    }

    // 유저 입력 처리
    private fun handleUserInput() {
        print(INPUT_GUIDE) // 입력 문구
        val input = Console.readLine()
        inputValidator.setUserInput(input)
        val isValidInput = inputValidator.checkIsValidInput()
        if (isValidInput) {
            userInputNumArr = Converter.convertStringToIntArr(input)
        }
//        println("userInputNumArr: $userInputNumArr")
    }
}
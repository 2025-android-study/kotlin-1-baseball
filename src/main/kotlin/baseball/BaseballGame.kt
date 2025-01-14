package baseball

import baseball.constants.GAME_DIGIT
import baseball.utils.MatchCounter
import baseball.utils.RandomNumberGenerator
import baseball.views.InputView
import baseball.views.OutputView

class BaseballGame {
    private var inputView = InputView
    private var outputView = OutputView

    val randomNumArr = RandomNumberGenerator.createRandomNumber() // 컴퓨터 숫자
    var userInputNumArr: List<Int> = mutableListOf() // 사용자가 입력한 숫자

    fun play() {
        inputView.printGameStartGuide()
        while (true) {
            userInputNumArr = inputView.getUserGuessDigit()

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
}
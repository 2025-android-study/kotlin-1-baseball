package baseball

import baseball.constants.GAME_DIGIT
import baseball.enums.GameRestartCondition
import baseball.utils.MatchCounter
import baseball.utils.RandomNumberGenerator
import baseball.views.InputView
import baseball.views.OutputView

class BaseballGame {
    private var inputView = InputView
    private var outputView = OutputView

    var randomNumArr: List<Int> = mutableListOf() // 컴퓨터 숫자
    var userInputNumArr: List<Int> = mutableListOf() // 사용자가 입력한 숫자

    fun play() {
        inputView.printGameStartGuide() // 게임 시작 문구 출력

        while (true) {
            val restartGame = playOneSet() // 게임 1세트
            if (!restartGame) break
        }
    }

    private fun playOneSet(): Boolean {
        // 난수 생성
        randomNumArr = RandomNumberGenerator.createRandomNumber()
//        println(randomNumArr)

        while (true) {
            // 사용자 입력 숫자 저장
            userInputNumArr = inputView.getUserGuessDigit()

            // 숫자 비교 진행
            val guessSuccess = compareArrData()

            // 숫자 모두 맞히기 성공
            if (guessSuccess) {
                // 게임 재시작 여부 묻기
                return askGameRestart()
            }
        }
    }

    private fun askGameRestart(): Boolean {
        inputView.askUserToRestartGame() // 게임 재시작 여부 묻기
        val restartCondition = inputView.getUserRestartCondition()

        return when (restartCondition) {
            GameRestartCondition.RESTART -> {
                true
            }
            GameRestartCondition.EXIT -> { // 게임 종료
                false
            }
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
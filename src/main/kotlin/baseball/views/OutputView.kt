package baseball.views

import baseball.constants.GAME_DIGIT
import baseball.constants.OUTPUT_GUESS_SUCCESS
import baseball.enums.MatchType
import baseball.model.MatchCount

object OutputView {
    fun printMatchResult(matchCount: MatchCount) {
        if (matchCount.strikeCount == 0 && matchCount.ballCount == 0) println(MatchType.NOTHING.text) // 낫싱
        else if (matchCount.strikeCount == GAME_DIGIT) println(OUTPUT_GUESS_SUCCESS) // 게임 종료
        else println("${matchCount.strikeCount}${MatchType.STRIKE.text} ${matchCount.ballCount}${MatchType.BALL.text}") // 힌트 출력
    }
}
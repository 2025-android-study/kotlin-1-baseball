package baseball.views

import baseball.constants.GAME_DIGIT
import baseball.constants.OUTPUT_GUESS_SUCCESS
import baseball.enums.MatchType
import baseball.model.MatchCount

object OutputView {
    // 결과 출력
    fun printMatchResult(matchCount: MatchCount) {
        if (matchCount.strikeCount == 0 && matchCount.ballCount == 0) println(MatchType.NOTHING.text) // 낫싱
        else if (matchCount.strikeCount == GAME_DIGIT) { // 숫자를 모두 맞혔을 떄
            println(getStrikeText(GAME_DIGIT))
            println(OUTPUT_GUESS_SUCCESS)
        }
        else { // 볼 or 스트라이크
            if (matchCount.strikeCount == 0) println(getBallText(matchCount.ballCount))
            else if (matchCount.ballCount == 0) println(getStrikeText(matchCount.strikeCount))
            else println("${getStrikeText(matchCount.strikeCount)} ${getBallText(matchCount.ballCount)}")
        }
    }

    private fun getStrikeText(strikeCount: Int): String {
        return "${strikeCount}${MatchType.STRIKE.text}"
    }

    private fun getBallText(ballCount: Int): String {
        return "${ballCount}${MatchType.BALL.text}"
    }
}
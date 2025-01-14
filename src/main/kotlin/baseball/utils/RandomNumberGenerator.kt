package baseball.utils

import baseball.constants.GAME_DIGIT
import baseball.constants.RANDOM_NUMBER_RANGE_END
import baseball.constants.RANDOM_NUMBER_RANGE_START
import camp.nextstep.edu.missionutils.Randoms

// 난수 생성기
object RandomNumberGenerator {
    fun createRandomNumber(): List<Int> {
        val computer: MutableList<Int> = mutableListOf()
        while (computer.size < GAME_DIGIT) { // 생성할 숫자의 자릿수
            val randomNumber = Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_START, RANDOM_NUMBER_RANGE_END) // 숫자 범위
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber)
            }
        }
        return computer
    }
}
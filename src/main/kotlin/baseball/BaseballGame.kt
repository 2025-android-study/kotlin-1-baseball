package baseball

import baseball.constants.GAME_START_GUIDE
import baseball.utils.RandomNumberGenerator

class BaseballGame {
    fun play() {
        println(GAME_START_GUIDE) // 게임 시작 문구 출력
        val randomNum = RandomNumberGenerator.createRandomNumber() // 난수 생성
//        print(randomNum)
    }
}
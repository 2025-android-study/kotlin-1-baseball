package baseball.constants

import baseball.enums.GameRestartCondition

const val GAME_START_GUIDE = "숫자 야구 게임을 시작합니다."
const val INPUT_GUIDE = "숫자를 입력해주세요 : "
val ASK_GAME_RESTART_GUIDE = "게임을 새로 시작하려면 ${GameRestartCondition.RESTART.value}, 종료하려면 ${GameRestartCondition.EXIT.value}를 입력하세요."

// 출력
const val OUTPUT_GUESS_SUCCESS = "3개의 숫자를 모두 맞히셨습니다! 게임 종료"

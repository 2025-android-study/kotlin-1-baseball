package baseball.consts

enum class OutputConst(s: String) {
    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_FINISHED("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    BALL("%d볼 "),
    STRIKE("%d스트라이크"),
    NOTHING("낫싱")
}
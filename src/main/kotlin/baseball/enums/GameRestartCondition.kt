package baseball.enums

enum class GameRestartCondition(var value: Int) {
    RESTART(1),
    EXIT(2);

    companion object {
        fun getConditionByValue(inputValue: Int): GameRestartCondition {
            return entries.find { it.value == inputValue } ?: EXIT
        }
    }
}


package baseball.consts

enum class ErrorConst(s: String) {
    INPUT_NOT_NUMBER("숫자를 입력해주세요."),
    INPUT_LENGTH_ERROR("세 자리 숫자를 입력해주세요."),
    INPUT_VALUE_ERROR("올바른 숫자를 입력해주세요."),
    INPUT_DUPLICATE_ERROR("중복된 숫자입니다.")
}
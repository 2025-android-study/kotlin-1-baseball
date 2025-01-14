package baseball.consts

enum class ErrorConst(s: String) {
    NOT_NUMBER("숫자를 입력해주세요."),
    LENGTH_ERROR("세 자리 숫자를 입력해주세요."),
    VALUE_ERROR("올바른 숫자를 입력해주세요."),
    DUPLICATE_ERROR("중복된 숫자입니다.")
}
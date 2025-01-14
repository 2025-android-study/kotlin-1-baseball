package baseball.utils

object Converter {
    fun convertStringToIntArr(inputString: String): List<Int> {
        return inputString.toCharArray().map {
            it.toString().toInt()
        }
    }
}
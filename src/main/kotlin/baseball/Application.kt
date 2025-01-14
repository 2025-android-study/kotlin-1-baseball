package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

var computer = mutableListOf<Int>()
var result = mutableListOf(0, 0)
var userNum = listOf<String>()
var gameEnd = 1

fun main() {
    println("숫자 야구 게임을 시작합니다.")

    while (gameEnd != 2) {
        gameSet()

        while(result[0] != 3) {
            result = mutableListOf(0, 0)
            print("숫자를 입력해주세요 : ")
            var tempNum = Console.readLine()
            checkNumValidation(tempNum)
            userNum = tempNum.split("").subList(1, 4)
            checkResult(0, 0)
            printResult()
        }

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        gameEnd = Console.readLine().toInt()
    }
}

// 컴퓨터 숫자 설정
fun gameSet(): MutableList<Int> {
    computer = mutableListOf()
    while (computer.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber)
        }
    }

    return computer
}

// 결과 비교
fun checkResult(computerIndex: Int, userIndex: Int) {
    if (computer[computerIndex] == userNum[userIndex].toInt()) {
        if (computerIndex == userIndex) {
            result[0] = result[0] + 1
        } else result[1] = result[1] + 1
    }

    if (userIndex != 2) {
        checkResult(computerIndex, userIndex + 1)
    } else if (computerIndex != 2) {
        checkResult(computerIndex + 1, 0)
    }
}

// 결과 출력
fun printResult() {
    if (result[0] == 0 && result[1] == 0) println("낫싱")
    else if (result[0] == 0) println("${result[1]}볼")
    else if (result[1] == 0) println("${result[0]}스트라이크")
    else println("${result[1]}볼 ${result[0]}스트라이크")
}

// 입력값 유효성 처리
fun checkNumValidation(num: String) {
    if (num.length != 3) {
        throw IllegalArgumentException("입력값은 3자리 숫자여야 합니다.")
    }

    try {
        num.toInt()
    } catch (e: IllegalArgumentException) {
        throw IllegalArgumentException("입력값은 3자리 숫자여야 합니다.")
    }
}
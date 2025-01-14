/**
 * [ 랜덤 3자리 수 재시작 시 재설정 ]
 *
 * [ 반복 ]
 * 3자리 수 입력
 * -> 같은 수가 같은자리 : 스트라이크
 * -> 같은 수가 다른 자리 : 볼
 * -> 같은 수가 전혀 없음 : 낫싱
 *
 * 맞추면 게임 종료
 * (1 누르면 재시작, 2 누르면 종료)
 *
 * for문: https://hwan-shell.tistory.com/244
 * 예외 발생시키기: https://observerlife.tistory.com/71
 * 특정 숫자 개수 확인: https://toonraon.tistory.com/43
 */
package baseball

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

private var strike = 0
private var ball = 0
private var end = false

private var randomNumbers = mutableListOf<Int>()

fun main() {
    // 랜덤 숫자 설정
    setRandomNumbers()

    println("숫자 야구 게임을 시작합니다.")

    while (!end) {
        strike = 0
        ball = 0
        end = false

        print("숫자를 입력해주세요 : ")
        val input = Console.readLine()
        val numbers = input.toCharArray()

        // 유효성 검사
        if (isInputInValid(input, numbers)) {
            throw IllegalArgumentException(("서로 다른 3자리 수를 입력해주세요"))
        }

        val result = findNumbers(numbers)
        println(result) // 결과 출력

        if (end) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")

            val isContinue = Console.readLine()
            if (isContinue.toInt() == 1) {
                setRandomNumbers() // 랜덤 숫자 재설정
                end = false // 게임 새로 시작
            }
        }
    }
}

// 랜덤 숫자 설정
fun setRandomNumbers() {
    randomNumbers.clear()
    while (randomNumbers.size < 3) {
        val randomNumber = Randoms.pickNumberInRange(1, 9)
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber)
        }
    }
}

// 입력 숫자 유효성 판단
fun isInputInValid(input: String, array: CharArray): Boolean {
    // 세자리 수 확인
    if (array.size != 3) {
        return true
    } else {
        for (i in 0..2) {
            if (input.count { it == array[i] } > 1) {
                return true
            }
        }
    }
    return false
}

// 숫자 포함 여부 확인
fun findNumbers(numbers: CharArray): String {
    for (i in 0..2) {
        // char to int
        val num = Character.getNumericValue(numbers[i])

        if (num == randomNumbers[i]) {
            strike++
        } else if (randomNumbers.contains(num)) {
            ball++
        }
    }

    return setResult()
}

// 결과 문구
fun setResult(): String {
    var result = ""

    if (ball != 0) {
        result += "${ball}볼 "
    }
    if (strike != 0) {
        if (strike == 3) {
            result = "3스트라이크"
            end = true
        } else {
            if (result == "") result = result.plus(" ")
            result += "${strike}스트라이크"
        }
    }

    if (ball == 0 && strike == 0) {
        result = "낫싱"
    }

    return result
}

import kotlin.math.abs

var count = 0
var n = 0
var board = IntArray(15)

// 유망한지 판단하는 함수
fun promising(cdx: Int): Boolean {

    // 같은 열이면 안되고, 대각선상에 있어서도 안 된다.
    for (i in 0 until cdx) {
        if (board[cdx] == board[i] || cdx - i == abs(board[cdx] - board[i])) {
            return false
        }
    }
    return true
}

// nqueen 알고리즘 수행
fun nqueen(cdx: Int) {

    // cdx가 마지막 행까지 수행하고 여기까지 오면, 찾기 완료
    if (cdx == n) {
        count++
        return
    }

    for (i in 0 until n) {
        board[cdx] = i // cdx번째 행, i번째 열에 queen을 놓아본다.
        // 이후 그 행에 둔 것에 대한 유망성을 판단한다.
        if (promising(cdx)) { // 그 자리에 두어도 괜찮았다면,
            nqueen(cdx + 1) // 그 다음 행에 대해 퀸을 놓는 것을 해 본다.
        }
    }
}

fun main() {
    n = readLine()!!.toInt()
    nqueen(0)
    println(count)
}
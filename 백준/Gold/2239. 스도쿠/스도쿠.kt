lateinit var sdokuMap: Array<IntArray>
lateinit var squareArr: Array<BooleanArray>
lateinit var initValue: Array<BooleanArray>

fun main() {
    initValue = Array(9) { BooleanArray(9) { false } }
    sdokuMap = Array(9) { y ->
        readln().chunked(1).mapIndexed { x, value ->
            val n = value.toInt()
            if (n > 0) {
                initValue[y][x] = true
            }
            n
        }.toIntArray()
    }

    initSquareArr()
    // println(squareArr.joinToString("\n"){it.joinToString(" ")})
    dfs(0, 0)
    //  println(getMySquareNum(3,8))

    /*
    가로랑 먼저 swap가능한지 check해서 swap하고
    자기 바로직전 부터
    그리고 처음 문제의 수는 건들이면 안댐.
    그담 세로랑 진행 ㄱㄱ
     */
}

var flg = false
fun dfs(y: Int, x: Int) {
    if (flg) return

    if (y == 9) {
        println(sdokuMap.joinToString("\n") { it.joinToString("") })
        flg = true
        return
    }

    val ny = if (x < 8) y else y + 1
    val nx = if (x < 8) x + 1 else 0
    if (sdokuMap[y][x] != 0) {
        dfs(ny, nx)
    } else {
        for (i in 1..9) {
            if (isValidateNum(i, y, x)) {
                sdokuMap[y][x] = i
                val nowSquareNum = getMySquareNum(y, x)
                squareArr[nowSquareNum][i] = true
                dfs(ny, nx)
                sdokuMap[y][x] = 0
                squareArr[nowSquareNum][i] = false
            }
        }
    }


}

fun initSquareArr() {
    squareArr = Array(9) { BooleanArray(10) { false } }

    for (i in 0 until 3) {
        for (y in 0 until 3) {
            for (x in 0 until 3) {
                val ry = y
                val rx = x + i * 3

                if (sdokuMap[ry][rx] > 0) {
                    squareArr[i][sdokuMap[ry][rx]] = true
                }
            }
        }
    }//0,1,2

    for (i in 0 until 3) {
        for (y in 3 until 6) {
            for (x in 0 until 3) {
                val ry = y
                val rx = x + i * 3

                if (sdokuMap[ry][rx] > 0) {
                    squareArr[i + 3][sdokuMap[ry][rx]] = true
                }
            }
        }
    }//3,4,5

    for (i in 0 until 3) {
        for (y in 6 until 9) {
            for (x in 0 until 3) {
                val ry = y
                val rx = x + i * 3

                if (sdokuMap[ry][rx] > 0) {
                    squareArr[i + 6][sdokuMap[ry][rx]] = true
                }
            }
        }
    }//6,7,8
}


fun isValidateNum(num: Int, y: Int, x: Int): Boolean {
    //3*3 내부 검사
    val nowSquareNum = getMySquareNum(y, x)
    if (squareArr[nowSquareNum][num]) return false

    //세로
    for (i in 0 until 9) {
        if (sdokuMap[i][x] == num) {
            return false
        }
    }

    //가로
    for (i in 0 until 9) {
        if (sdokuMap[y][i] == num) {
            return false
        }
    }

    return true
}


fun getMySquareNum(y: Int, x: Int): Int {
    var ret = -1
    when {
        y in 0..2 -> {
            when {
                x in 0..2 -> {
                    ret = 0
                }

                x in 3..5 -> {
                    ret = 1
                }

                x in 6..8 -> {
                    ret = 2
                }
            }
        }

        y in 3..5 -> {
            when {
                x in 0..2 -> {
                    ret = 3
                }

                x in 3..5 -> {
                    ret = 4
                }

                x in 6..8 -> {
                    ret = 5
                }
            }
        }

        y in 6..8 -> {
            when {
                x in 0..2 -> {
                    ret = 6
                }

                x in 3..5 -> {
                    ret = 7
                }

                x in 6..8 -> {
                    ret = 8
                }
            }
        }
    }

    return ret
}

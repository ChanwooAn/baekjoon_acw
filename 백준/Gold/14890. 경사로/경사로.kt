
lateinit var wayMap: Array<IntArray>
lateinit var visit: Array<BooleanArray>


fun main() {
    val (n, l) = readln().split(" ").map { it.toInt() }
    wayMap = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    visit = Array(n) { BooleanArray(n) { false } }
    var answer = 0

    //가로
    OutLoop@ for (i in 0 until n) {
        var j = 1
        while (j < n) {
            val diffWithPrev = wayMap[i][j] - wayMap[i][j - 1]
            when (diffWithPrev) {
                0 -> {
                    j++
                    continue
                }

                1 -> {
                    if (checkPossibleHorizontal(i, j, diffWithPrev, l)) {
                        j++
                        continue
                    } else {
                        continue@OutLoop
                    }
                }

                -1 -> {
                    if (checkPossibleHorizontal(i, j, diffWithPrev, l)) {
                        j += l
                        continue
                    } else {
                        continue@OutLoop
                    }

                }

                else -> {
                    continue@OutLoop
                }
            }
        }
        answer++
    }

    visit = Array(n) { BooleanArray(n) { false } }
    //세로

    OutLoop@ for (i in 0 until n) {
        var j = 1
        while (j < n) {
            val diffWithPrev = wayMap[j][i] - wayMap[j-1][i]
            when (diffWithPrev) {
                0 -> {
                    j++
                    continue
                }

                1 -> {
                    if (checkPossibleVertical(j, i, diffWithPrev, l)) {
                        j++
                        continue
                    } else {
                        continue@OutLoop
                    }
                }

                -1 -> {
                    if (checkPossibleVertical(j, i, diffWithPrev, l)) {
                        j += l
                        continue
                    } else {
                        continue@OutLoop
                    }

                }

                else -> {
                    continue@OutLoop
                }
            }
        }
        answer++
    }

    println(answer)
}

fun checkPossibleHorizontal(y: Int, x: Int, diff: Int, l: Int): Boolean {

    if (diff == 1) {
        //현재 더 크다.
        if (x < l) {
            return false
        }
        val height = wayMap[y][x - 1]
        for (i in x - 1 downTo x - l) {
            if (wayMap[y][i] != height) {
                return false
            }
            if (visit[y][i]) {
                return false
            }
            visit[y][i] = true
        }
        return true
    } else {
        if (x + l - 1 > wayMap.size - 1) {
            return false
        }
        val height = wayMap[y][x]
        for (i in x until x + l) {
            if (wayMap[y][i] != height) {
                return false
            }
            if (visit[y][i]) {
                return false
            }
            visit[y][i] = true
        }
        return true
    }
}
fun checkPossibleVertical(y: Int, x: Int, diff: Int, l: Int): Boolean {

    if (diff == 1) {
        //현재 더 크다.
        if (y < l) {
            return false
        }
        val height = wayMap[y-1][x]
        for (i in y - 1 downTo y - l) {
            if (wayMap[i][x] != height) {
                return false
            }
            if (visit[i][x]) {
                return false
            }
            visit[i][x] = true
        }
        return true
    } else {
        if (y + l - 1 > wayMap.size - 1) {
            return false
        }
        val height = wayMap[y][x]
        for (i in y until y + l) {
            if (wayMap[i][x] != height) {
                return false
            }
            if (visit[i][x]) {
                return false
            }
            visit[i][x] = true
        }
        return true
    }

}
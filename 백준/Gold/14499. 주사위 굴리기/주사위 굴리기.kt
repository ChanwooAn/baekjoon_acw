lateinit var diceMap: Array<Array<Int>>

const val South = 4
const val North = 3
const val West = 2
const val East = 1

data class Dice(var pos: Pos) {
    val side = Array<Int>(6) { 0 }

    fun move(command: Int, N: Int, M: Int): Boolean {
        if (!pos.move(command, N, M)) {
            return false
            //이동할 수 없을 경우 바로 return
        }
        val prev = side.copyOf()
        when (command) {
            East -> {
                side[1] = prev[5]
                side[5] = prev[3]
                side[2] = prev[1]
                side[3] = prev[2]
            }

            West -> {
                side[1] = prev[2]
                side[5] = prev[1]
                side[2] = prev[3]
                side[3] = prev[5]

            }

            North -> {
                side[0] = prev[2]
                side[2] = prev[4]
                side[4] = prev[5]
                side[5] = prev[0]
            }

            South -> {
                side[0] = prev[5]
                side[2] = prev[0]
                side[4] = prev[2]
                side[5] = prev[4]
            }
        }

        if (diceMap[pos.y][pos.x] != 0) {
            side[5] = diceMap[pos.y][pos.x]
            diceMap[pos.y][pos.x] = 0
        } else {
            diceMap[pos.y][pos.x] = side[5]
        }

        return true
    }


}

data class Pos(var y: Int, var x: Int) {
    fun move(command: Int, N: Int, M: Int): Boolean {
        when (command) {
            North -> {
                if (y - 1 < 0) {
                    return false
                }
                y--
            }

            South -> {
                if (y + 1 > N - 1) {
                    return false
                }
                y++
            }

            West -> {
                if (x - 1 < 0) {
                    return false
                }
                x--
            }

            East -> {
                if (x + 1 > M - 1) {
                    return false
                }
                x++
            }
        }
        return true
    }
}

fun main() {
    val (N, M, x, y, K) = readln().split(" ").map { it.toInt() }
    diceMap = Array(N) { readln().split(" ").map { it.toInt() }.toTypedArray() }
    val command = readln().split(" ").map { it.toInt() }
    var diceNow = Dice(Pos(x, y))
    for (c in command) {
        if (!diceNow.move(c, N, M)) continue
        println(diceNow.side[2])
    }

}

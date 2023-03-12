import java.util.*

lateinit var field: Array<Array<IntArray>>
fun main() {
    val (width, length, height) = readln().split(" ").map { it.toInt() }


    field = Array(height) { Array(length) { readln().split(" ").map { it.toInt() }.toIntArray() } }

    for (h in 0 until height) {
        for (y in 0 until length) {
            for (x in 0 until width) {
                if (field[h][y][x] == 1) {
                    q.add(Node(h, y, x, 0))
                }
            }
        }
    }
    val min = bfs(height, length, width)

    for (h in 0 until height) {
        for (y in 0 until length) {
            for (x in 0 until width) {
                if (field[h][y][x] == 0) {
                    println(-1)
                    return
                }
            }
        }
    }

    println(min)


}


val dy = listOf(-1, 1, 0, 0, 0, 0)
val dx = listOf(0, 0, 1, -1, 0, 0)
val dh = listOf(0, 0, 0, 0, 1, -1)
val q = LinkedList<Node>()

data class Node(var h: Int, var y: Int, var x: Int, var day: Int)

fun bfs(Height: Int, Length: Int, Width: Int): Int {

    var now: Node = Node(0, 0, 0, 0)
    while (q.isNotEmpty()) {
        now = q.removeFirst()


        for (i in 0 until 6) {
            val nh=now.h+dh[i]
            val ny = now.y + dy[i]
            val nx = now.x + dx[i]

            if (nh<0||nh>=Height||ny < 0 || nx < 0 || ny >= Length || nx >= Width) {
                continue
            }
            if (field[nh][ny][nx] != 0) {
                continue
            }
            q.add(Node(nh, ny, nx, now.day + 1))
            field[nh][ny][nx] = 1
        }
    }


    return now.day
}
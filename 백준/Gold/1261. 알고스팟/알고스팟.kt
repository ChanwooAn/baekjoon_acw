import java.util.*

lateinit var maze: Array<IntArray>
lateinit var dist: Array<IntArray>
val dx = listOf(1, 0, -1, 0) // right, down, left, up
val dy = listOf(0, 1, 0, -1)

fun main() {
    val (width, height) = readLine()!!.split(" ").map { it.toInt() }

    maze = Array(height) { readLine()!!.chunked(1).map { it.toInt() }.toIntArray() }
    dist = Array(height) { IntArray(width) { Int.MAX_VALUE } }
    dist[0][0] = 0

    val pq = PriorityQueue<Triple<Int, Int, Int>>(compareBy { it.first })
    pq.add(Triple(0, 0, 0))

    while (pq.isNotEmpty()) {
        val (crashCount, y, x) = pq.poll()

        if (y == height - 1 && x == width - 1) {
            println(crashCount)
            return
        }

        for (i in 0 until 4) {
            val ny = y + dy[i]
            val nx = x + dx[i]
            if (ny < 0 || nx < 0 || ny >= height || nx >= width) {
                continue
            }
            val nextCrashCount = crashCount + maze[ny][nx]
            if (nextCrashCount < dist[ny][nx]) {
                dist[ny][nx] = nextCrashCount
                pq.add(Triple(nextCrashCount, ny, nx))
            }
        }
    }
}
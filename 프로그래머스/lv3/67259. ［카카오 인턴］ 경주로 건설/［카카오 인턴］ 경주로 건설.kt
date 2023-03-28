import java.util.*

data class State(val x: Int, val y: Int, val direction: Int, val cost: Int)
class Solution {
  

fun solution(board: Array<IntArray>): Int {
    val n = board.size
    val dx = listOf(0, 0, 1, -1)
    val dy = listOf(1, -1, 0, 0)

    val queue: Queue<State> = LinkedList()
    val visited = Array(n) { Array(n) { IntArray(4) { Int.MAX_VALUE } } }

    queue.offer(State(0, 0, 2, 0)) // Initial direction set to 2 (down)
    queue.offer(State(0, 0, 0, 0)) // Initial direction set to 0 (right)

    for (i in 0..3) {
        visited[0][0][i] = 0
    }

    while (queue.isNotEmpty()) {
        val (x, y, direction, cost) = queue.poll()

        for (i in 0..3) {
            val nx = x + dx[i]
            val ny = y + dy[i]

            if (nx in 0 until n && ny in 0 until n && board[nx][ny] == 0) {
                val newCost = if (direction == i) cost + 100 else cost + 600

                if (visited[nx][ny][i] > newCost) {
                    visited[nx][ny][i] = newCost
                    queue.offer(State(nx, ny, i, newCost))
                }
            }
        }
    }

    return visited[n - 1][n - 1].minOrNull() ?: Int.MAX_VALUE
}
}
import java.lang.Integer.min

lateinit var dist: Array<IntArray>

fun main() {
    val (N, M, X) = readLine()!!.split(" ").map { it.toInt() }
    dist = Array(N + 1) { IntArray(N + 1) { 100001 } }

    repeat(M) {
        val (s, e, c) = readLine()!!.split(" ").map { it.toInt() }
        dist[s][e] = c
    }

    floyd(N)
    val roundTrip = IntArray(N + 1) { 0 }
    for (i in 1..N) {
        roundTrip[i] = dist[i][X] + dist[X][i]
    }
    println(roundTrip.max())
}

fun floyd(n: Int) {
    for (i in 1..n) {
        dist[i][i] = 0
    }
    for (k in 1 until n + 1) {
        for (i in 1 until n + 1) {
            for (j in 1 until n + 1) {
                dist[i][j] = min(dist[i][j], dist[i][k] + dist[k][j])
            }
        }
    }
}
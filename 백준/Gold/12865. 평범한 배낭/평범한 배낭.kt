lateinit var dpTable: Array<IntArray>

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    dpTable = Array(n + 1) { IntArray(k + 1) { 0 } }

    repeat(n) {
        val (weight, value) = readln().split(" ").map { it.toInt() }
        for (i in 1..k) {
            if (weight > i) {
                dpTable[it + 1][i] = dpTable[it][i]
            }
            else{
                dpTable[it+1][i]=maxOf(dpTable[it][i],dpTable[it][i-weight]+value)
            }
        }
    }
    println(dpTable[n][k])
}
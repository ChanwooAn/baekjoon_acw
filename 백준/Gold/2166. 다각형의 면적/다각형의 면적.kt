import kotlin.math.abs

fun ccw(a: Int, b: Int, c: Int, x: DoubleArray, y: DoubleArray): Double {
    val aa = doubleArrayOf(y[b] - y[a], x[b] - x[a])
    val bb = doubleArrayOf(y[c] - y[a], x[c] - x[a])
    val temp = aa[0] * bb[1] - aa[1] * bb[0]
    return temp / 2
}

fun main() {
    val num = readLine()!!.toInt()
    val x = DoubleArray(num)
    val y = DoubleArray(num)
    for (i in 0 until num) {
        val input = readLine()!!.split(" ").map { it.toDouble() }
        x[i] = input[0]
        y[i] = input[1]
    }
    var result = 0.0
    for (i in 1 until num - 1) {
        result += ccw(0, i, i + 1, x, y)
    }
    println("%.1f".format(abs(result)))
}
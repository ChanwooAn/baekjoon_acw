val arr = IntArray(100)
val cost = IntArray(10001) { if (it == 0) 0 else 10001 }

fun main() {
    val (n,k) = readln().split(" ").map{it.toInt()}


    for (i in 0..k) {
        cost[i] = 10001
    }

    for (i in 0 until n) {
        arr[i] = readln().toInt()
        if (arr[i] < k + 1) {
            cost[arr[i]] = 1
        }
    }

    for (i in 1..k) {
        for (j in 0 until n) {
            if (i - arr[j] < 0) {
                continue
            }

            if (cost[i] > cost[i - arr[j]] + 1) {
                cost[i] = cost[i - arr[j]] + 1
            }
        }
    }

    if (cost[k] != 10001) {
        println(cost[k])
    } else {
        println(-1)
    }
}
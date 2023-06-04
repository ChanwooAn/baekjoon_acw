lateinit var dpArr: IntArray
val gapList = arrayListOf<Int>()


fun main() {
    val n = readln().toInt()
    val m = readln().toInt()


    var maxGap = 0
    var lastVip = 0
    repeat(m) {
        val vip = readln().toInt()
        val gapNow = vip - lastVip - 1
        maxGap = maxOf(maxGap, gapNow)
        gapList.add(gapNow)
        lastVip = vip
    }

    if (lastVip != n) {
        val lastGap = n - lastVip
        maxGap = maxOf(maxGap, lastGap)
        gapList.add(lastGap)
    }


    dpArr = IntArray(if(maxGap + 1>1) maxGap+1 else 2) { 0 }



    var answer = 1
    dpArr[0] = 1
    dpArr[1] = 1
    for (i in 2..maxGap) {
        dpArr[i] = dpArr[i - 1] + dpArr[i - 2]
    }

    for (gap in gapList) {
        answer *= dpArr[gap]
    }

    println(answer)
}
lateinit var arr: Array<Pair<Int, Int>>
fun main() {
    val n = readln().toInt()
    arr = readln().split(" ").mapIndexed { idx, value -> Pair(value.toInt(), idx) }.toTypedArray()
    arr.sortBy { it.first }
    var now = 0

    var biggerCnt = 0
    var prev = arr[0].first
    for (i in arr.indices) {
        if (arr[i].first == prev) {
            continue
        } else {
            for (j in now until i) {
                arr[j] = Pair(biggerCnt, arr[j].second)
            }
            now = i
            biggerCnt++
            prev = arr[i].first
            //새로운 숫자만났을 때
        }
    }


    for (j in now until arr.size) {
        arr[j] = Pair(biggerCnt, arr[j].second)
    }


    arr.sortBy { it.second }
    println(arr.map { it.first }.joinToString(" "))


}
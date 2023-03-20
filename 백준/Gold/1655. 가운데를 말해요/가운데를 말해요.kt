import java.util.*
val br=System.`in`.bufferedReader()
val bw=System.`out`.bufferedWriter()
fun main() {
    val n = readLine()!!.toInt()
    val maxHeap = PriorityQueue<Int>(compareByDescending { it })
    val minHeap = PriorityQueue<Int>()

    for (i in 1..n) {
        val num = br.readLine().toInt()

        if (maxHeap.size == minHeap.size) {
            maxHeap.offer(num)
        } else {
            minHeap.offer(num)
        }

        if (minHeap.isNotEmpty() && maxHeap.peek() > minHeap.peek()) {
            val max = maxHeap.poll()
            val min = minHeap.poll()
            maxHeap.offer(min)
            minHeap.offer(max)
        }

        bw.write("${maxHeap.peek()}\n")
    }
    bw.close()
    br.close()
}

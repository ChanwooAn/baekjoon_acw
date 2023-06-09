import java.util.PriorityQueue

val pq=PriorityQueue<Long>()
fun main(){
    val (n,m)=readln().split(" ").map{it.toInt()}

    readln().split(" ").map{pq.add(it.toLong())}

    var cnt=0
    while(pq.isNotEmpty() &&cnt<m){
        cnt++

        val a=pq.poll()
        val b=pq.poll()
        pq.addAll(listOf(a+b,a+b))
    }


    println(pq.sum())
}
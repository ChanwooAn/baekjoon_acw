import java.util.*
import kotlin.collections.ArrayList

lateinit var dist:IntArray
lateinit var graph:Array<ArrayList<Pair<Int,Int>>>
fun main(){
    val (n,m)=readln().split(" ").map{it.toInt()}
    dist=IntArray(n+1){Int.MAX_VALUE}
    graph=Array(n+1){arrayListOf()}
    for(i in 0 until m){
        val (a,b,c)= readln().split(" ").map{it.toInt()}
        graph[a].add(Pair(b,c))
        graph[b].add(Pair(a,c))
    }
    dijkstra(1)
    println(dist[n])
}


fun dijkstra(start:Int){
    val pq= PriorityQueue<Pair<Int,Int>>(compareBy{it.second})
    pq.add(Pair(start,0))
    dist[start]=0

    while(pq.isNotEmpty()){
        val (nodeNow,costUntilNow)=pq.poll()

        if(dist[nodeNow]<costUntilNow){
            continue
        }
        for((nextNode,costNowToNext) in graph[nodeNow]){
            val costUntilNext=costUntilNow+costNowToNext
            if(dist[nextNode]>costUntilNext){
                dist[nextNode]=costUntilNext
                pq.add(Pair(nextNode,costUntilNext))
            }
        }
    }
}
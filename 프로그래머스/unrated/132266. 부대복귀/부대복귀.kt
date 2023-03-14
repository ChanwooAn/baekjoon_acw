import java.util.*
import kotlin.collections.ArrayList
class Solution {


lateinit var dist: IntArray
lateinit var graph: Array<ArrayList<Int>>
val q= PriorityQueue<Pair<Int,Int>>(compareBy{it.second})
fun solution(n: Int, roads: Array<IntArray>, sources: IntArray, destination: Int): IntArray {
    var answer = mutableListOf<Int>()
    dist = IntArray(n + 1) { Int.MAX_VALUE }
    graph = Array(n + 1) { arrayListOf() }


    for (i in roads) {
        graph[i[0]].add(i[1])
        graph[i[1]].add(i[0])
    }
    dijkstra(destination)
    for(i in sources){
        if(dist[i]==Int.MAX_VALUE){
            answer.add(-1)
        }else{
            answer.add(dist[i])
        }
    }

    return answer.toIntArray()
}

fun dijkstra(start: Int) {
    q.add(Pair(start,0))
    dist[start]=0

    while(q.isNotEmpty()){
        val (now,untilNowDist)=q.poll()
        if(dist[now]<untilNowDist){
            continue
        }

        for(i in graph[now]){
            val cost=untilNowDist+1
            if(cost<dist[i]){
                dist[i]=cost
                q.add(Pair(i,cost))
            }
        }
    }
}
}
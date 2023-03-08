import java.util.*
import kotlin.collections.ArrayList

lateinit var graph:Array<ArrayList<Int>>
lateinit var dist:Array<Int>

val pq= PriorityQueue<Pair<Int,Int>>(compareBy{it.second})


fun main(){
    val(numOfCity,numOfRoads,distance,startCity)= readln().split(" ").map{it.toInt()}

    graph=Array(numOfCity+1){ arrayListOf() }
    dist=Array(numOfCity+1){Int.MAX_VALUE}
    repeat(numOfRoads){
        val (s,e)= readln().split(" ").map { it.toInt() }
        graph[s].add(e)
    }

    dijkstra(startCity)

    var flg=false
    for(i in 1..numOfCity){
        if(dist[i]==distance){
            println(i)
            flg=true
        }
    }
    if(!flg){
        println(-1)
    }

}
fun dijkstra(s:Int){
    pq.add(Pair(s,0))
    dist[s]=0

    while (pq.isNotEmpty()){
        val now=pq.poll()
        if(now.second<dist[now.first]){
            continue
        }
        for(i in graph[now.first]){
            val c=now.second+1
            if(dist[i]>c){
                dist[i]=c
                pq.add(Pair(i,c))
            }
        }
    }
}
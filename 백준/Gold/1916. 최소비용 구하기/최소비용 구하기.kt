import java.util.PriorityQueue

lateinit var graph:Array<ArrayList<Pair<Int,Int>>>//다른도시, cost
lateinit var dist:Array<Int>
val q= PriorityQueue<Pair<Int,Int>>(compareBy{it.second})

fun main(){
    val n= readln().toInt()
    val m= readln().toInt()
    graph=Array(n+1){ arrayListOf() }
    dist=Array(n+1){Int.MAX_VALUE}
    repeat(m){
        val (s,e,c)= readln().split(" ").map { it.toInt() }
        graph[s].add(Pair(e,c))
    }//도시 연결하기

    val (depart,arrive)= readln().split(" ").map { it.toInt() }
    dijkstra(depart)
    println(dist[arrive])
}
fun dijkstra(depart:Int){
    q.add(Pair(depart,0))
    dist[depart]=0

    while(q.isNotEmpty()){
        val (cityNow,cost)=q.poll()
        if(dist[cityNow]<cost) continue

        for(i in graph[cityNow]){
            val nextCost=cost+i.second
            if(dist[i.first]>nextCost){
                dist[i.first]=nextCost
                q.add(Pair(i.first,nextCost))
            }
        }
    }
}
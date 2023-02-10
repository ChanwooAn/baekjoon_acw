    import java.util.PriorityQueue

class Solution {

lateinit var dist:Array<Int>
val q=PriorityQueue<Pair<Int,Int>>(compareBy{it.second})
lateinit var graph:Array<ArrayList<Pair<Int,Int>>>
fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
    var answer = 0
    dist=Array(N+1){Int.MAX_VALUE}
    graph=Array(N+1){ arrayListOf() }
    for(i in road){
        graph[i[0]].add(Pair(i[1],i[2]))
        graph[i[1]].add(Pair(i[0],i[2]))

    }
    q.add(Pair(1,0))
    dist[1]=0

    while(q.isNotEmpty()){
        val (now,cost)=q.poll()
        if(dist[now]<cost){
            continue
        }
        for(edge in graph[now]){
            val newCost=cost+edge.second

            if(newCost<dist[edge.first]){
                dist[edge.first]=newCost
                q.add(Pair(edge.first,newCost))
            }
        }
    }
    for(i in dist){
        if(i<=k) answer++
    }

    return answer
}

}
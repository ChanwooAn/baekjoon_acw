import java.util.PriorityQueue

val q=PriorityQueue<Int>()
lateinit var indegreeArr:Array<Int>
lateinit var graph:Array<ArrayList<Int>>

fun main(){
    val (n,m)= readln().split(" ").map { it.toInt() }
    val answer= arrayListOf<Int>()
    indegreeArr=Array(n+1){0}
    graph=Array(n+1){ arrayListOf() }

    repeat(m){
        val (before,after)= readln().split(" ").map { it.toInt() }
        indegreeArr[after]++
        graph[before].add(after)
    }

    for(i in 1..n){
        if(indegreeArr[i]==0) q.add(i)
    }


    while(q.isNotEmpty()){
        val now=q.poll()
        answer.add(now)

        for(i in graph[now]){
            indegreeArr[i]--

            if(indegreeArr[i]==0){
                q.add(i)
            }
        }

    }

    println(answer.joinToString(" "))

}
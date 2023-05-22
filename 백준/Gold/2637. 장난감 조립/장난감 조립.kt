import java.util.*
import kotlin.collections.ArrayList

lateinit var indegree:IntArray
lateinit var resource:Array<IntArray>
lateinit var graph:Array<ArrayList<Int>>
val basicParts=LinkedList<Int>()

fun main(){
    val n=readln().toInt()
    indegree=IntArray(n+1){0}
    graph=Array(n+1){ arrayListOf() }
    resource=Array(n+1){IntArray(n+1){0}}
    val m= readln().toInt()

    repeat(m){
        val (big,small,cnt)= readln().split(" ").map{it.toInt()}
        graph[small].add(big)

        indegree[big]++
        resource[big][small]=cnt
    }

    topologySort()

    for(i in basicParts){
        if(resource[n][i]==0){
            continue
        }
        println("$i ${resource[n][i]}")
    }

}
fun topologySort(){
    val q= LinkedList<Int>()
    for(i in 1 until indegree.size){
        if(indegree[i]==0){
            q.add(i)
            basicParts.add(i)
        }
    }//지금 넣는 이게 기본 부품.

    while(q.isNotEmpty()){
        val now=q.removeFirst()

        for(nextNode in graph[now]){
            indegree[nextNode]--
            for(i in basicParts){
                resource[nextNode][i]+=(resource[nextNode][now]*resource[now][i])
            }
            if(indegree[nextNode]==0){
                q.add(nextNode)
            }
        }
    }
}

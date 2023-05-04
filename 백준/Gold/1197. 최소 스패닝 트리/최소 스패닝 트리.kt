import java.util.*

lateinit var parent:IntArray

data class Edge(val a:Int,val b:Int,val cost:Int)
fun main(){
    val (numOfNode, numOfEdge)=readln().split(" ").map{it.toInt()}
    parent=IntArray(numOfNode+1){it}
    val pq= PriorityQueue<Edge>(compareBy{it.cost})
    repeat(numOfEdge){
        val (a,b,c)=readln().split(" ").map{it.toInt()}
        pq.add(Edge(a,b,c))
    }

    var answer=0L
    while(pq.isNotEmpty()){
        val now=pq.poll()
        if(findParent(now.a)==findParent(now.b)){
            continue
        }
        else{
            union(now.a,now.b)
            answer+=now.cost
        }

    }

    println(answer)


}
fun findParent(c:Int):Int{
    if(parent[c]!=c){
        parent[c]=findParent(parent[c])
    }

    return parent[c]
}
fun union(a:Int,b:Int){
    val aP=findParent(a)
    val bP=findParent(b)

    if(aP<bP){
        parent[bP]=aP
    }else{
        parent[aP]=bP
    }

}
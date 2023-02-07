
lateinit var parent:IntArray
val graph= arrayListOf<Road>()

data class Road(
    var start:Int,
    var end:Int,
    var cost:Int
)

fun main(){
    var answer=0
    var max=0
    val (n,m)= readln().split(" ").map{it.toInt()}
    parent= IntArray(n+1){it}
    repeat(m){
        val (s,e,c)= readln().split(" ").map { it.toInt() }
        graph.add(Road(s,e,c))
    }
    graph.sortWith(compareBy {it.cost})

    for(edge in graph){
        val (s,e,c)=edge
        if(findParent(s)!=findParent(e)){
            unionParent(s,e)
            answer+=c
            if(c>max){
                max=c
            }
        }
    }

    println(answer-max)
}
fun unionParent(a:Int,b:Int){
    val c1=findParent(a)
    val c2=findParent(b)

    if(c1<c2){
        parent[c2]=c1
    }else{
        parent[c1]=c2
    }
}

fun findParent(x:Int):Int{
    if(parent[x]!=x){
        parent[x]=findParent(parent[x])
    }
    return parent[x]
}
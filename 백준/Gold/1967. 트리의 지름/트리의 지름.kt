
lateinit var graph:Array<ArrayList<Pair<Int,Int>>>

fun main(){
    val n= readln().toInt()
    graph=Array(n+1){ arrayListOf() }
    repeat(n-1){
        val (s,e,c)= readln().split(" ").map { it.toInt() }
        graph[s].add(Pair(e,c))
    }
    findMax(1,0)
    println(answer)
}
var answer=0

fun findMax(nodeNum:Int,dist:Int):Int{
    if(graph[nodeNum].isEmpty()){
        return dist
    }

    var firstHalf=0
    var secondHalf=0

    for(i in graph[nodeNum]){
        //자식
        val child=findMax(i.first,i.second)
        if(child>firstHalf){
            secondHalf=firstHalf
            firstHalf=child
        }else if(child>secondHalf){
            secondHalf=child
        }
    }
    val diameter=firstHalf+secondHalf
    if(diameter>answer){
        answer=diameter
    }

    return firstHalf+dist

}
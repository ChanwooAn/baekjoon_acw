lateinit var graph: Array<ArrayList<Pair<Int,Int>>>
lateinit var visit:BooleanArray
fun main() {
    val n = readln().toInt()
    graph = Array(n + 1) { arrayListOf() }
    visit=BooleanArray(n+1){false}
    val inputList= mutableListOf<List<Int>>()
    repeat(n) {
        inputList.add(readln().split(" ").map{it.toInt()})
    }
    inputList.sortBy{it[0]}

    for(input in inputList){
        val parent=input[0]
        for(i in 1 until input.lastIndex step 2){
            graph[parent].add(Pair(input[i],input[i+1]))
        }
    }

    for(i in 1..n){
        if(!visit[i]){
            findMax(i,i, 0)
        }
    }

    println(answer)
}

var answer = 0

fun findMax(parent:Int,nodeNum: Int, dist: Int): Int {
    visit[nodeNum]=true

    if (graph[nodeNum].isEmpty() ||(graph[nodeNum].size==1&& graph[nodeNum][0].first==parent)) {
        return dist
    }

    //현재 경로상에 있는 node이면 안된다.
    var firstHalf = 0
    var secondHalf = 0

    for (i in graph[nodeNum]) {
        //자식
        if(visit[i.first]){
            continue
        }
        if(i.first==parent){
            continue
        }
        val child = findMax(nodeNum,i.first, i.second)
        if (child > firstHalf) {
            secondHalf = firstHalf
            firstHalf = child
        } else if (child > secondHalf) {
            secondHalf = child
        }
    }
    val diameter = firstHalf + secondHalf
    if (diameter > answer) {
        answer = diameter
    }

    return firstHalf + dist

}
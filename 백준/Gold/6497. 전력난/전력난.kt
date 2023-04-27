
data class Road(val house1:Int,val house2:Int,val cost:Int)
lateinit var roadList:MutableList<Road>
lateinit var parent:IntArray
fun main(){
    while(true){
        val (houseNum,roadNum)= readln().split(" ").map { it.toInt() }
        if(houseNum==0 && roadNum==0){
            break
        }
        roadList= mutableListOf()
        parent=IntArray(houseNum){it}
        var answer=0
        repeat(roadNum){
            val (s,e,c)= readln().split(" ").map { it.toInt() }
            roadList.add(Road(s,e,c))
        }//길 입력받기
        roadList.sortBy{it.cost}

        for((a,b,cost) in roadList){
            if(findParent(a)==findParent(b)){
                continue
            }
            union(a,b)
            answer+=cost
        }

        println(roadList.sumOf{it.cost}-answer)

    }

}
fun union(a:Int,b:Int){
    val parentA=findParent(a)
    val parentB=findParent(b)

    if(parentA<parentB){
        parent[parentB]=parentA
    }else{
        parent[parentA]=parentB
    }
}
fun findParent(c:Int):Int{
    if(c!=parent[c]){
        parent[c]=findParent(parent[c])
    }

    return parent[c]
}
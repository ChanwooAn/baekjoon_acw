import java.util.PriorityQueue

lateinit var distance:Array<Int>
var roads= PriorityQueue(Comparator<Triple<Int,Int,Int>>{
    a,b->
    a.first-b.first
})



fun main(){
    val (K,D)=readln().split(" ").map{it.toInt()}
    distance=Array(10001){it}


    for(i in 1..K){
        val (s,e,c)=readln().split(" ").map{it.toInt()}

        if(e>D){
            continue
        }
        //목표보다 높은 지점을 향하는 지름길은 받지 않기

        if(c>=(e-s)){
            continue
        }
        //지름길이 cost가 더 클경우도 받지 않기

        roads.add(Triple(s,e,c))
    }

    while(roads.isNotEmpty()){
        val (s,e,c)=roads.poll()
        if(distance[e]-distance[s]>c){
            distance[e]=distance[s]+c
            for(j in e+1..D){
                if(distance[j-1]+1<distance[j]){
                    distance[j]=distance[j-1]+1
                }
            }
        }
    }



    println(distance[D])






}
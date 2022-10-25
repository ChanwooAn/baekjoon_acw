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

        if(c>=(e-s)){
            continue
        }

        roads.add(Triple(s,e,c))
    }

    while(roads.isNotEmpty()){
        val (s,e,c)=roads.poll()
        if(distance[e]-distance[s]>c){
            distance[e]=distance[s]+c
        }

        for(j in e+1..D){
            if(distance[j-1]+1<distance[j]){
                distance[j]=distance[j-1]+1

            }
        }
    }



    println(distance[D])






}
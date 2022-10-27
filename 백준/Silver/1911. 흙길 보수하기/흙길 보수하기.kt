import java.util.PriorityQueue

fun main(){
    val (N,L)= readln().split(" ").map{it.toInt()}
    var bridgeEnd=1
    var answer=0
    val puddle=PriorityQueue<Pair<Int,Int>>{
        a,b->
        a.first-b.first
    }
    repeat(N){
        val (s,e)=readln().split(" ").map{it.toInt()}
        puddle.add(Pair(s,e))
    }
    while(puddle.isNotEmpty()){
        var (s,e)= puddle.poll()
        if(bridgeEnd>s){
           s=bridgeEnd
        }
        while(s<e){
            s+=L
            answer++
        }
        bridgeEnd=s
    }

    println(answer)


}
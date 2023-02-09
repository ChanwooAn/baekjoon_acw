import java.util.*

val bag= PriorityQueue<Int>()
val jewel=PriorityQueue<Pair<Int,Int>>(compareBy{it.first})
val possibleJewel=PriorityQueue<Pair<Int,Int>>(compareBy{-it.second})


fun main(){
    val (n,k)= readln().split(" ").map { it.toInt() }
    repeat(n){
        val (weight,cost)= readln().split(" ").map { it.toInt() }
        jewel.add(Pair(weight,cost))
    }

    repeat(k){
        val bagWeight= readln().toInt()
        bag.add(bagWeight)
    }

    var answer=0L
    while(bag.isNotEmpty()){
        val bagNow=bag.poll()
        while(jewel.isNotEmpty()){
            val jewelNow=jewel.peek()
            if(jewelNow.first<=bagNow){
                possibleJewel.add(jewelNow)
                jewel.poll()
                continue
            }
            break
        }

        if(possibleJewel.isEmpty()) continue
        //현재 가방에 담을 수 있는 보석이 없을 경우 그냥 continue

        val mostValue=possibleJewel.poll()
        answer+=mostValue.second


    }

    println(answer)
}
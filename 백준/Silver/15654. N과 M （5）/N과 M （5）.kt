import java.util.*

val totalComb= mutableListOf<List<Int>>()

fun main(){
    val (n,m)= readln().split(" ").map { it.toInt() }


    comb(m, readln().split(" ").map { it.toInt() }.sorted(),LinkedList<Int>(),BooleanArray(n),0)

    println(totalComb.joinToString("\n"){it.joinToString(" ")})

}

fun comb(size:Int, arr:List<Int>, lis: LinkedList<Int>, visit:BooleanArray, depth:Int){
    if(depth==size){
        totalComb.add(lis.toMutableList())
        return
    }
    for(i in arr.indices){
        if(visit[i]){
            continue
        }
        lis.add(arr[i])
        visit[i]=true
        comb(size,arr,lis,visit,depth+1)
        lis.removeLast()
        visit[i]=false

    }

}
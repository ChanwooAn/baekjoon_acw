import java.util.*

val br=System.`in`.bufferedReader()
val numList=PriorityQueue<Int>()

fun main(){
    val n=br.readLine().toInt()
    repeat(n){
        val num=br.readLine().toInt()
        numList.add(num)
    }

    println(calc())
}
fun calc():Int{
    var answer=0
    while(numList.size>1){
        val a=numList.poll()
        val b=numList.poll()

        val new=a+b
        numList.add(new)
        answer+=new
    }
    return answer
}
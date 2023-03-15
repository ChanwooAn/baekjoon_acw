import java.util.*

val q=TreeMap<Int,Int>()

fun main(){
    val testCaseNum= readln().toInt()

    repeat(testCaseNum){
        q.clear()
        val operationNum= readln().toInt()
        for(i in 0 until operationNum){
            val operation= readln().split(" ")
            if(operation[0]=="I"){
                q.put(operation[1].toInt(),q.getOrDefault(operation[1].toInt(),0)+1)
            }else{
                if(q.size==0){
                    continue
                }

                if(operation[1]=="1"){
                    val lastEntry=q.lastEntry()
                    val lastkey=lastEntry.key
                    val lastValue=lastEntry.value
                    q.remove(q.lastKey())
                    if(lastValue!=1){
                        q.put(lastkey,lastValue-1)
                    }
                }else{
                    val firstEntry=q.firstEntry()
                    val firstkey=firstEntry.key
                    val firstValue=firstEntry.value
                    q.remove(q.firstKey())
                    if(firstValue!=1){
                        q[firstkey] = firstValue-1
                    }
                }
            }
        }



        if(q.size==0){
            println("EMPTY")
        }
        else{
            println("${q.lastKey()} ${q.firstKey()}")
        }
    }


}
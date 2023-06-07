import java.util.*
import kotlin.math.absoluteValue

val br=System.`in`.bufferedReader()
val bw=System.`out`.bufferedWriter()


val pq= PriorityQueue<Int>{a,b->
    val aabs=a.absoluteValue
    val babs=b.absoluteValue
    if(aabs!=babs){
        aabs-babs
    }else{
        a-b
    }
}


fun main(){
    val n=br.readLine().toInt()

    repeat(n){
        val input=br.readLine().toInt()
        if(input==0){
            if(pq.isEmpty()){
                bw.write("0\n")
            }
            else{
                bw.write("${pq.poll().toString()}\n")
            }
        }else{
            pq.add(input)
        }
    }

    bw.close()
    br.close()
}
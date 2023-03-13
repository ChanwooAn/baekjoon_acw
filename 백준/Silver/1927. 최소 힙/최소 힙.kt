import java.util.*

val q = PriorityQueue<Int>()
fun main() {
    val n = readln().toInt()

    repeat(n){
        val num= readln().toInt()
        if(num==0){
            if(q.isEmpty()){
                println(0)
            }else{
                println(q.poll())
            }
        }else{
            q.add(num)
        }
    }

}
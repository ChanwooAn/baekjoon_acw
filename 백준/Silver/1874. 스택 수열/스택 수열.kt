import java.util.*

val br=System.`in`.bufferedReader()
val inputList= mutableListOf<Int>()
val st= LinkedList<Int>()

fun main(){
    val n=br.readLine().toInt()
    var answer=StringBuilder()
    repeat(n){
        inputList.add(br.readLine().toInt())
    }

    var stackNow=0

    for(i in inputList){
        while(stackNow<i){
            st.addLast(stackNow+1)
            stackNow++
            answer.append("+\n")
        }

        if(st.isEmpty()){
            println("NO")
            return
        }

        if(st.last==i){
            st.removeLast()
            answer.append("-\n")
        }else{
            println("NO")
            return
        }
    }

    println(answer)

}
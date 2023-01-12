import kotlin.math.abs
import kotlin.math.max

const val MAX=10000000

lateinit var arr:Array<Int>
var result=0

fun Int.pow(n:Int):Int{
    var ret=this
    for(i in 0 until n){
        ret*=2
    }
    return ret
}

fun solution(n:Int,tSize:Int,nodeNum:Int):Int{
    if(nodeNum*2>=tSize){
        result+=arr[nodeNum]
        return arr[nodeNum]
    }else{
        val left=solution(n,tSize,nodeNum*2)
        val right=solution(n,tSize,nodeNum*2+1)

        result+=arr[nodeNum]+ abs(left-right)
        return arr[nodeNum]+ max(left,right)

    }

}
fun main(){
    val k= readln().toInt()
    val treeSize=2.pow(k+1)-1
    arr=Array(treeSize+3){0}

    val input=readln().split(" ").map { it.toInt() }
    for(i in input.indices){
        arr[i+2]=input[i]
    }

    solution(k,treeSize,1)
    println(result)
}
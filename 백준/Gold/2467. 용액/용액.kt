import kotlin.math.absoluteValue

fun main(){
    val n=readln().toInt()
    val arr=readln().split(" ").map{it.toInt()}.toIntArray()

    var left=0
    var right=n-1
    var minDiff=Int.MAX_VALUE
    var ansL=-1
    var ansR=-1

    while(left<right){
        val diff=arr[left]+arr[right]
        if(minDiff.absoluteValue>diff.absoluteValue){
            minDiff=diff
            ansL=left
            ansR=right
        }
        when{
            diff<0->{
                left++
            }
            diff==0->{
                println("${arr[left]} ${arr[right]}")
                return
            }
            else->{
                right--
            }
        }

    }

    println("${arr[ansL]} ${arr[ansR]}")

}
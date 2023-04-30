lateinit var arr:IntArray
var answer=Int.MAX_VALUE

fun main(){
    val (n,s)=readln().split(" ").map{it.toInt()}
    arr=readln().split(" ").map{it.toInt()}.toIntArray()

    var l=0
    var r=0
    var sumNow=arr[0]
    while(true){
        if(sumNow<s){
            r++
            if(r>n-1)break
            sumNow+=arr[r]
        }else{
            findShortest(l,r)
            sumNow-=arr[l]
            l++
            if(l>r){
                break
            }
        }
    }


    if(answer==Int.MAX_VALUE){
        println(0)
    }else{
        println(answer+1)
    }
}
fun findShortest(i:Int,j:Int){
    val diff=j-i
    if(diff<answer){
        answer=diff
    }
}
var zeroArr=Array(41){0}
var oneArr=Array(41){0}

fun fibonacci(num:Int){
    zeroArr[0]=1
    zeroArr[1]=0

    oneArr[0]=0
    oneArr[1]=1

    for(i in 2..num){
        zeroArr[i]=zeroArr[i-1]+zeroArr[i-2]
        oneArr[i]=oneArr[i-1]+oneArr[i-2]
    }
}

fun main(){
    val T=readln().toInt()

    repeat(T){
        val num=readln().toInt()
        fibonacci(num)
        println("${zeroArr[num]} ${oneArr[num]}")
    }

}
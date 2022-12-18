val arr=Array(10001){true}


fun delNonSelfNum(num:Int):Int{
    val numNow=num.toString()
    var sum=0
    for(i in numNow){
        sum+=i.digitToInt()
    }
    sum+=num

    return sum
}
fun main(){

    for(i in 1 until 10000){
        if(arr[i]){
            println(i)
        }
        val delNum=delNonSelfNum(i)
        if(delNum<=10000){
            arr[delNum]=false
        }
    }


}
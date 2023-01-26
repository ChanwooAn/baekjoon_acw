fun main(){
    val n= readln().toInt()
    val dpArr=Array(100001){0}

    dpArr[1]=3
    dpArr[2]=7
    dpArr[3]=17
    dpArr[4]=41

    if(n<5) {
        println(dpArr[n])
        return
    }

    for(i in 5..n){
        dpArr[i]=(dpArr[i-1]*2+dpArr[i-2])%9901
    }

    println(dpArr[n])

}
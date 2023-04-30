
lateinit var dpArr:IntArray
lateinit var history:Array<MutableList<Int>>
fun main(){
    val n=readln().toInt()
    dpArr=IntArray(n+1){Int.MAX_VALUE}
    history=Array(n+1){mutableListOf()}

    dpArr[0]=0
    dpArr[1]=0
    history[1]=mutableListOf(1)
    for(i in 1..n){
        if(i+1<=n){
            if(dpArr[i+1]>dpArr[i]+1){
                dpArr[i+1]=dpArr[i]+1
                history[i+1]=history[i].toMutableList().apply{add(i+1)}
            }
        }

        if(3*i<=n){
            if(dpArr[3*i]>dpArr[i]+1){
                dpArr[3*i]=dpArr[i]+1
                history[3*i]=history[i].toMutableList().apply{add(3*i)}
            }
        }

        if(2*i<=n){
            if(dpArr[2*i]>dpArr[i]+1){
                dpArr[2*i]=dpArr[i]+1
                history[2*i]=history[i].toMutableList().apply{add(2*i)}
            }
        }
    }

    println(dpArr[n])
    println(history[n].reversed().joinToString(" "))
}

import java.lang.Integer.max

lateinit var appMemory:IntArray
lateinit var appCost:IntArray
lateinit var dpArr:Array<IntArray>


fun main(){
    val (n,m)= readln().split(" ").map { it.toInt() }
    appMemory= readln().split(" ").map { it.toInt() }.toIntArray()
    appCost= readln().split(" ").map { it.toInt() }.toIntArray()

    val maxCost=appCost.sum()
    dpArr=Array(n+1){IntArray(maxCost+1){0}}


    for(i in 1 .. n){
        val appMemoryNow=appMemory[i-1]
        val appCostNow=appCost[i-1]

        for(j in 0 .. maxCost){
            if(j-appCostNow>=0) {
                dpArr[i][j] = max(dpArr[i][j], dpArr[i - 1][j - appCostNow] + appMemoryNow)
            }//현재 앱을 제외시켰을 경우에 더 큰 메모리를 얻을 수 있다면 update

            dpArr[i][j]=max(dpArr[i][j],dpArr[i-1][j])

        }
    }


    for(i in 0..maxCost){
        if(dpArr[n][i]>=m){
            println(i)
            break
        }
    }



}
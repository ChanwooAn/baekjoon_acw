
val totalComb= mutableListOf<List<Int>>()
fun main(){
    val (n,m)= readln().split(" ").map { it.toInt() }

    comb(m, IntArray(n+1){0},1,0)

    println(totalComb.joinToString("\n"){it.joinToString(" ")})


}

fun comb(size:Int,visit:IntArray,start:Int,depth:Int){
    if(depth==size){
        val lis= mutableListOf<Int>()
        for((idx,value) in visit.withIndex()){
            var cnt=0
            while(cnt!=value){
                lis.add(idx)
                cnt++
            }
        }
        totalComb.add(lis)
        return
    }
    for(i in start until visit.size){
        visit[i]++
        comb(size,visit,i,depth+1)
        visit[i]--

    }

}
lateinit var dist:Array<IntArray>
const val INF=100000
fun main(){
    val testCaseNum= readln().toInt()
    repeat(testCaseNum){
        val(nodeNum,roadNum,wormHallNum)= readln().split(" ").map { it.toInt() }
        dist=Array(nodeNum+1){IntArray(nodeNum+1){INF} }
        for(i in 0 until roadNum){
            val (s,e,c)= readln().split(" ").map { it.toInt() }
            dist[s][e]=minOf(dist[s][e],c)
            dist[e][s]=minOf(dist[e][s],c) 
        }
        for(i in 0 until wormHallNum){
            val (s,e,c)= readln().split(" ").map { it.toInt() }
            dist[s][e]=minOf(dist[s][e],-c)
        }
        floidWassal(nodeNum)

        var answer="NO"
        loop1@for(i in 1..nodeNum){
            for(j in 1..nodeNum){
                if(dist[i][j]+dist[j][i]<0){
                    answer="YES"
                    break@loop1
                }
            }
        }
        println(answer)
    }
}

fun floidWassal(n:Int){
    for(k in 1..n){
        for(i in 1..n){
            for(j in 1..n){
                if(dist[i][k]==INF||dist[k][j]==INF){
                    continue
                }
                dist[i][j]=minOf(dist[i][j],dist[i][k]+dist[k][j])
            }
        }
    }
}

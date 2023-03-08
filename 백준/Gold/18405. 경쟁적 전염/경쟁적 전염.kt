import java.util.*

lateinit var virusMap:Array<IntArray>
lateinit var startList:Array<ArrayList<Pair<Int,Int>>>
val q= LinkedList<Triple<Int,Int,Int>>()
fun main(){
    val (n,k)= readln().split(" ").map { it.toInt() }
    virusMap=Array(n){ readln().split(" ").map{it.toInt()}.toIntArray() }
    startList=Array(k+1){ arrayListOf() }
    val (time,targetY,targetX)= readln().split(" ").map { it.toInt() }

    for(y in 0 until n){
        for(x in 0 until n){
            if(virusMap[y][x]>0){
                startList[virusMap[y][x]].add(Pair(y,x))
            }
        }
    }

    for(i in 1..k){
        for(j in startList[i]){
            q.add(Triple(j.first,j.second,0))
        }
    }
    bfs(n,time)

    println(virusMap[targetY-1][targetX-1])

}
val dx= listOf(-1,1,0,0)
val dy=listOf(0,0,-1,1)
fun bfs(n:Int,timeLimit:Int){
    while(q.isNotEmpty()){
        val (y,x,time)=q.poll()
        if(time>=timeLimit){
            break
        }
        for(i in 0 until 4){
            val ny=y+dy[i]
            val nx=x+dx[i]

            if(ny<0||nx<0||ny>=n||nx>=n){
                continue
            }
            if(virusMap[ny][nx]!=0){
                continue
            }

            virusMap[ny][nx]=virusMap[y][x]
            q.add(Triple(ny,nx,time+1))
        }
    }
}
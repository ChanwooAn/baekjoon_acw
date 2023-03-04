lateinit var field:Array<IntArray>
fun main(){
    val T= readln().toInt()

    repeat(T){
        var cnt=0
        val (N,M,K)= readln().split(" ").map{it.toInt()}//가로 세로 개수
        field=Array(M){IntArray(N){0} }
        for(i in 0 until K){
            val (x,y)= readln().split(" ").map { it.toInt() }
            field[y][x]=1
        }
        for(i in 0 until M){
            for(j in 0 until N){
                if(field[i][j]==1){
                    bfs(i,j,M,N)
                    cnt++
                }
            }
        }

        println(cnt)
    }
}


val dy=listOf(-1,1,0,0)
val dx= listOf(0,0,1,-1)

fun bfs(y:Int,x:Int,Height:Int,Width:Int){
    val q=ArrayList<Pair<Int,Int>>()

    q.add(Pair(y,x))
    field[y][x]=0
    while(q.isNotEmpty()){
        val now=q.removeFirst()

        for(i in 0 until 4){
            val ny=now.first+dy[i]
            val nx=now.second+dx[i]

            if(ny<0||nx<0||ny>=Height||nx>=Width){
                continue
            }
            if(field[ny][nx]!=1){
                continue
            }
            q.add(Pair(ny,nx))
            field[ny][nx]=0
        }

    }
}
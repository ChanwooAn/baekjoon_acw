lateinit var mountain:Array<IntArray>
lateinit var visit:Array<BooleanArray>
val dy=listOf(1,1,1,-1,-1,-1,0,0)
val dx=listOf(-1,0,1,-1,0,1,-1,1)

fun main(){
    val(n,m)= readln().split(" ").map{it.toInt()}
    mountain=Array(n){ readln().split(" ").map { it.toInt() }.toIntArray() }
    visit=Array(n){BooleanArray(m){false} }
    var answer=0

    for(i in 0 until n){
        for(j in 0 until m){
            if(!visit[i][j]){
                peakFlg=true
                dfs(i,j)
                if(peakFlg){
                    answer++
                }
            }
        }
    }
    println(answer)

}
var peakFlg=true
fun dfs(y:Int,x:Int){
    if(visit[y][x]){
        return
    }
    visit[y][x]=true

    for(i in 0 until 8){
        val ny=y+dy[i]
        val nx=x+dx[i]
        if(ny<0||nx<0||ny>mountain.size-1||nx>mountain[0].size-1){
            continue
        }
        if(mountain[ny][nx]<mountain[y][x]){
            continue
            //작을 경우 탐색하지 않음
        }else if(mountain[ny][nx]>mountain[y][x]){
            //클 경우 탐색하지 않지만 flg를 false로 하여 peak이 아님을 표시
            peakFlg=false
            continue
        }

        if(visit[ny][nx]){
            continue
        }
        dfs(ny,nx)
    }
}
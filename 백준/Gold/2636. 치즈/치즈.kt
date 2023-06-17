import java.util.*

lateinit var cheeseArr:Array<IntArray>
lateinit var visit:Array<BooleanArray>

val lastCheeseQueue= LinkedList<Pair<Int,Int>>()
val tmpQueue=LinkedList<Pair<Int,Int>>()
fun main(){
    val (height,width)=readln().split(" ").map{it.toInt()}

    cheeseArr=Array(height){readln().split(" ").map{it.toInt()}.toIntArray()}
    visit=Array(height){BooleanArray(width){false}}

    for(i in 0 until width){
        lastCheeseQueue.add(Pair(0,i))
        lastCheeseQueue.add(Pair(height-1,i))
    }
    for(i in 1 until height){
        lastCheeseQueue.add(Pair(i,0))
        lastCheeseQueue.add(Pair(i,width-1))
    }

    var answer=0

    var time=0
    while(deleteOutside(time)!=0){
        answer=cnt
        time+=100
    }
    
    println(time/100)
    println(answer)


}

val dx=listOf(1,-1,0,0)
val dy=listOf(0,0,1,-1)
var cnt=0

fun deleteOutside(time:Int):Int{
    cnt=0
    lastCheeseQueue.addAll(tmpQueue)
    tmpQueue.clear()

    while(lastCheeseQueue.isNotEmpty()){
        val now=lastCheeseQueue.poll()
        if(visit[now.first][now.second]){
            continue
        }
        dfs(now.first,now.second,time)
    }
    return cnt
}

fun dfs(y:Int,x:Int,time:Int){
    visit[y][x]=true

    for(i in 0 until 4){
        val ny=y+dy[i]
        val nx=x+dx[i]

        if(ny<0 || nx<0 || ny>visit.size-1 || nx>visit[0].size-1){
            continue
        }
        if(visit[ny][nx]){
            continue
        }

        when(cheeseArr[ny][nx]){
            time+100->{
                continue
            }
            time, 0->{
                dfs(ny,nx,time)
            }
            1->{
                cheeseArr[ny][nx]=time+100
                cnt++
                tmpQueue.add(Pair(ny,nx))
            }
        }


    }

}
import java.util.*

lateinit var wallMap:Array<IntArray>
lateinit var visit:Array<Array<VisitState>>

data class VisitState(var havePower:Boolean,var noPower:Boolean)
data class MoveData(var y:Int,var x:Int,var power:Int,var depth:Int)
fun main(){
    val (height,width)= readln().split(" ").map { it.toInt() }
    wallMap=Array(height){readln().chunked(1).map { it.toInt() }.toIntArray()}
    visit=Array(height){Array(width){VisitState(false,false)} }
    val q= LinkedList<MoveData>()


    q.add(MoveData(0,0,1,1))
    visit[0][0].havePower=true

    val dy=listOf(1,-1,0,0)
    val dx=listOf(0,0,1,-1)

    while(q.isNotEmpty()){
        val (y,x,power,depth)=q.removeFirst()
        if(y==height-1 && x==width-1){
            println(depth)
            return
        }

        for(i in 0 until 4){
            val ny=y+dy[i]
            val nx=x+dx[i]
            if(ny<0||nx<0||ny>=height||nx>=width){
                continue
            }
            if(power==1 && visit[ny][nx].havePower){
                continue
            }else if(power==0 && visit[ny][nx].noPower){
                continue
            }

            if(wallMap[ny][nx]==1){
                //벽일 때
                if(power==1 && !visit[ny][nx].noPower){
                    visit[ny][nx].noPower=true
                    q.add(MoveData(ny,nx,0,depth+1))
                }
            }else{
                //그냥 지나갈 수 있을 때
                if(power==1){
                    visit[ny][nx].havePower=true
                    q.add(MoveData(ny,nx,power,depth+1))
                }else{
                    visit[ny][nx].noPower=true
                    q.add(MoveData(ny,nx,power,depth+1))
                }
            }

        }

    }
    println(-1)

}

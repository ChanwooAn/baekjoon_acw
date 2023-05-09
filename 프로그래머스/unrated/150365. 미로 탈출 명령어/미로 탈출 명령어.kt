import kotlin.math.*

class Solution {
    var mazeWidth=0
    var mazeHeight=0
    var maxDistance=0
    var targetY=0 
    var targetX=0
    lateinit var visit:Array<Array<BooleanArray>>
    
    var answer="impossible"
    fun solution(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
        mazeWidth=m
        mazeHeight=n
        maxDistance=k
        targetY=r
        targetX=c
        visit=Array(n){Array(m){BooleanArray(k+1){false}}}
        dfs(x,y,0,"")
        
        println(answer)
        
        return answer
    }
    
    val dy=listOf(1,0,0,-1)
    val dx=listOf(0,-1,1,0)
    //사전순 d l r u
    var flg=false
    fun dfs(y:Int,x:Int,dist:Int,pathHistory:String){
        //println("$y $x $dist $pathHistory")
        
        visit[y-1][x-1][dist]=true
        
        if(dist>maxDistance){
            return
        }
        if(flg){
            return
        }
        
        if(y==targetY && x==targetX && dist==maxDistance){
            flg=true
            answer=pathHistory
            return
        }
        for(i in 0 until 4){
            val ny=y+dy[i]
            val nx=x+dx[i]
            val dir=when{
                i==0->{
                    "d"
                }
                i==1->{
                    "l"
                }
                i==2->{
                    "r"
                }
                i==3->{
                    "u"
                }
                else->{
                    ""
                }
            }
            if(ny>mazeHeight||nx>mazeWidth||ny<1||nx<1){
                continue
            }
            if(!calcIsValidate(ny,nx,maxDistance-dist-1)){
                continue
            }
            if(visit[ny-1][nx-1][dist+1]){
                continue
            }
            dfs(ny,nx,dist+1,pathHistory+dir)
        }
        
        
    }
    
    fun calcIsValidate(ny:Int,nx:Int,leftDist:Int):Boolean{
        val distToTarget=(targetY-ny).absoluteValue+(targetX-nx).absoluteValue
        if(distToTarget>leftDist){
            return false
        }else{
            return true
        }
    }
    
}
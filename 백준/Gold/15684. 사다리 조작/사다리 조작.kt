lateinit var ladderArr:Array<IntArray>
const val LEFT=1
const val RIGHT=2

fun main(){
    val (w,l,h)=readln().split(" ").map{it.toInt()}
    ladderArr=Array(h){IntArray(w){0}}

    repeat(l){
        val (y,x)= readln().split(" ").map{(it.toInt()-1)}
        ladderArr[y][x]=RIGHT
        ladderArr[y][x+1]=LEFT
    }//기존 사다리 입력 처리

    for(ladderCnt in 0 .. 3){
        if(answer!=-1){
            break
        }
        dfsLadderSelect(0,ladderCnt,0,0)
    }


    println(answer)

}
var answer=-1

fun dfsLadderSelect(depth:Int,targetDepth:Int,prevY:Int,prevX:Int){
    if(answer!=-1){
        return
    }

    if(depth==targetDepth){
        if(simulate()){
            answer=depth
        }
        return
    }

    for(x in prevX until ladderArr[0].size){
        if(ladderArr[prevY][x]!=0){
            continue
        }
        if(x!=ladderArr[0].size-1 && ladderArr[prevY][x+1]==0){
            ladderArr[prevY][x]=RIGHT
            ladderArr[prevY][x+1]=LEFT
            dfsLadderSelect(depth+1,targetDepth,prevY,x)
            ladderArr[prevY][x]=0
            ladderArr[prevY][x+1]=0
        }
        if(answer!=-1){
            return
        }
    }


    for(y in prevY+1 until ladderArr.size){
        for(x in 0 until ladderArr[0].size){
            if(ladderArr[y][x]!=0){
                continue
            }
            if(x!=ladderArr[0].size-1 && ladderArr[y][x+1]==0){
                ladderArr[y][x]=RIGHT
                ladderArr[y][x+1]=LEFT
                dfsLadderSelect(depth+1,targetDepth,y,x)
                ladderArr[y][x]=0
                ladderArr[y][x+1]=0
            }
            if(answer!=-1){
                return
            }
        }
    }


}
fun simulate():Boolean{
    for(x in ladderArr[0].indices){
        var nowX=x
        for(y in ladderArr.indices){
            when(ladderArr[y][nowX]) {
                0 -> {
                    continue
                }

                LEFT -> {
                    nowX--
                }

                RIGHT -> {
                    nowX++
                }
            }
        }
        if(nowX!=x){
            return false
        }
    }

    return true
}
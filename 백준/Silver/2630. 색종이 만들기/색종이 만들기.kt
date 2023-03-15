
lateinit var paperMap:Array<IntArray>
const val BLUE=1
const val WHITE=0
var blueNum=0
var whiteNum=0
fun main(){
    val n= readln().toInt()
    paperMap=Array(n){ readln().split(" ").map { it.toInt() }.toIntArray() }

    recursiveFold(0,n-1,0,n-1)
    println("$whiteNum\n$blueNum")
}

fun recursiveFold(startX:Int,endX:Int,startY:Int,endY:Int){
    val color=paperMap[startY][startX]
    for(i in startY..endY){
        for(j in startX..endX){
            if(paperMap[i][j]!=color){
                val midX=(startX+endX)/2
                val midY=(startY+endY)/2
                recursiveFold(startX,midX,startY,midY)
                recursiveFold(midX+1,endX,startY,midY)
                recursiveFold(startX,midX,midY+1,endY)
                recursiveFold(midX+1,endX,midY+1,endY)

                return
            }
        }
    }
    if(color==BLUE){
        blueNum++
    }else{
        whiteNum++
    }
}
lateinit var video:Array<Array<Int>>
var answer=""

fun divide(y:Int,x:Int,n:Int){
    var flg=false

    var firstNum=video[y][x]

    for(i in y until y+n){
        for(j in x until x+n){
            if(video[i][j]!=firstNum){
                val nextSize=n/2
                answer+="("
                divide(y,x,nextSize)
                divide(y,x+nextSize,nextSize)
                divide(y+nextSize,x,nextSize)
                divide(y+nextSize,x+nextSize,nextSize)
                answer+=")"
                return
            }
        }
    }
    answer+=firstNum

}


fun main(args: Array<String>) {
    var N= readln().toInt()
    video=Array(N){ Array(N){0} }

    repeat(N){n->
        video[n]= readln().chunked(1).map { it.toInt() }.toTypedArray()
    }

    divide(0,0,N)

    println(answer)

}
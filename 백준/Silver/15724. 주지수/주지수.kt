
lateinit var peopleMap:Array<Array<Int>>
lateinit var dpMap:Array<Array<Int>>
fun main(){
    val (N,M)= readln().split(" ").map{it.toInt()}
    peopleMap=Array(N){ readln().split(" ").map{it.toInt()}.toTypedArray()}
    dpMap=Array(N){y->Array(M){x->peopleMap[y][x]}}

    val K= readln().toInt()


    for(i in 0 until N){
        for(j in 1 until M){
            dpMap[i][j]=dpMap[i][j-1]+peopleMap[i][j]
        }
    }//가로 합만 일단 먼저 계산

    for(y in 1 until N){
        for(x in 0 until M){
            dpMap[y][x]=dpMap[y-1][x]+dpMap[y][x]
        }
    }//세로 더하여 dp map 완성하기

    for(i in 1..K){
        val (y1,x1,y2,x2)= readln().split(" ").map{it.toInt()}
        var sum=dpMap[y2-1][x2-1]

        if(x1>1){
            sum-=dpMap[y2-1][x1-2]
        }

        if(y1>1){
            sum-=dpMap[y1-2][x2-1]
        }

        if(y1>1 && x1>1){
            sum+=dpMap[y1-2][x1-2]
        }



        println(sum)
    }
}
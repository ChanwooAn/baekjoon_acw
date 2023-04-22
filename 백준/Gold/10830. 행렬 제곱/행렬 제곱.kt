lateinit var matrix:Array<IntArray>
fun main(){
    val (a,b)=readln().trim().split(" ").map { it.toLong() }
    matrix=Array(a.toInt()){ readln().trim().split(" ").map { it.toInt()%1000 }.toIntArray() }
    println(solution(b).joinToString ("\n"){it.joinToString(" ")  })
}
fun matrixMultiply(a:Array<IntArray>,b:Array<IntArray>):Array<IntArray>{
    val ret=Array(a.size){IntArray(a.size){0}}
    for(i in a.indices){
        for(j in a.indices){
            for(k in b.indices){
                ret[i][j]=(ret[i][j]+a[i][k]*b[k][j])%1000
            }
        }
    }
    return ret
}
fun solution(n:Long):Array<IntArray>{
    if(n==1L){
        return matrix
    }else{
        if(n%2==0L){
            //짝수
            val tmp=solution(n/2)
            return matrixMultiply(tmp,tmp)
        }else{
            //홀수
            val tmp=solution(n/2)
            return matrixMultiply(matrixMultiply(tmp,tmp),matrix)
        }

    }
}
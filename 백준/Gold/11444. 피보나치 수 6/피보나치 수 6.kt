lateinit var matrix:Array<LongArray>
const val divider=1_000_000_007

fun main(){
    val n=readln().toLong()

    matrix=Array(2){ longArrayOf() }
    matrix[0]= longArrayOf(1,1)
    matrix[1]= longArrayOf(1,0)

    println(solution(n)[0][1])
}
fun matrixMultiply(a:Array<LongArray>,b:Array<LongArray>):Array<LongArray>{
    val ret=Array(a.size){LongArray(a.size){0}}
    for(i in a.indices){
        for(j in a.indices){
            for(k in b.indices){
                ret[i][j]=((ret[i][j])+(a[i][k]*b[k][j])%divider)%divider
            }
        }
    }
    return ret
}
fun solution(n:Long):Array<LongArray>{
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
import java.math.*

val sb=StringBuilder()
var answer= BigInteger.ZERO
fun main(){
    val n=readln().toInt()
    if(n<21){
        recursiveHanoi(n,1,2,3)
        print(answer)
        println(sb)
    }else{
        calcBigHanoi(n)
        println(answer)
    }

}
fun calcBigHanoi(n:Int){
    answer++
    var cnt=n
    while(cnt>0){
        answer=answer.multiply(BigInteger.valueOf(2))
        cnt--
    }
    answer--
}
fun recursiveHanoi(n:Int,start:Int,via:Int,end:Int){
    if(n==1){
        //맨 밑 원반일 경우 바로 옮기기
        sb.append("\n$start $end")
        answer++
        return
    }else{
        recursiveHanoi(n-1,start,end,via)//n-1개를 다른 기둥으로 옮기기
        sb.append("\n$start $end")//맨 밑 원반을 옮기기
        answer++
        recursiveHanoi(n-1,via,start,end)//옮긴 n-1개의 기둥을 다시 옮기기
    }
}

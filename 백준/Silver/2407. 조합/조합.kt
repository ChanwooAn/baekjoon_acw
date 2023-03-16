import java.math.BigInteger

fun main(){
    val (n,m)= readln().split(" ").map { it.toInt() }
    var top= BigInteger.ONE
    var n_=n
    var cnt=0
    while(cnt<m){
        top*=n_.toBigInteger()
        n_--
        cnt++
    }
    var bottom=BigInteger.ONE
    var m_=m
    while(m_>0){
        bottom*=m_.toBigInteger()
        m_--
    }
    println(top/bottom)


}
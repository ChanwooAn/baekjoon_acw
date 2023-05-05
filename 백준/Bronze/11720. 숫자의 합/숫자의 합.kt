fun main(){
    val n=readln().toInt()
    var sum=0
    readln().chunked(1).map{sum+=it.toInt()}
    println(sum)
}
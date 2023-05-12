fun main(){
    val same="=="
    val rightIsBig="<"
    val leftIsBig=">"
    
    val (a,b)=readln().split(" ").map{it.toInt()}
    when{
        a<b->{
            println(rightIsBig)
        }
        a>b->{
            println(leftIsBig)
        }
        else->{
            println(same)
        }
    }
}
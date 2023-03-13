fun main(){
    val (n,r,c)=readln().split(" ").map{it.toInt()}//r행 c열
    //네모는 2 2

    var startY=0
    var endY=binarySquare(n)
    var startX=0
    var endX=endY

    var size=endY-startY
    var answer=0
    while(size>1){
        val midX=startX+(endX-startX)/2
        val midY=startY+(endY-startY)/2
        var multiplyer=0

        if(midY<=r){
            //밑의거 3, 4번중에 하나
            multiplyer+=2
            startY=midY
        }else{
            endY=midY
        }

        if(midX<=c){
            //오른쪽 꺼 즉 2, 4번
            multiplyer++
            startX=midX
        }else{
            endX=midX
        }
        size=endY-startY
        answer+=size*size*multiplyer


    }

    println(answer)

}
fun binarySquare(n:Int):Int{
    var ret=1
    var cnt=n
    while(cnt>0){
        ret*=2
        cnt--
    }
    return ret
}

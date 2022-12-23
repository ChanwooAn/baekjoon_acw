fun main(){
    val n= readln().toInt()
    val visit=Array(n+1){false}
    val answerList= arrayListOf<Int>()
    var maxValue=2
    while(maxValue<=2*n){
        maxValue*=2
    }
    maxValue/=2
    if(maxValue<2) maxValue*=2
    for(i in n downTo 1){
        var targetWeight=maxValue

        while(targetWeight-i>n){
            targetWeight/=2
        }

        var b=targetWeight-i
        while(visit[b]){
            targetWeight/=2
            b=targetWeight-i
        }
        answerList.add(b)
        visit[b]=true
    }
    for(i in answerList.size-1 downTo 0){
        println(answerList[i])
    }
}
lateinit var input:Array<Int>
lateinit var sushi:Array<Int>
lateinit var sushiKind:Array<Int>
private val N by lazy{
    input[0]
}
private val d by lazy{
    input[1]
}
private val k by lazy{
    input[2]
}
private val c by lazy{
    input[3]
}


fun countSushi():Int{
    var answer=0
    val arr= hashSetOf<Int>()
    var first=0
    var now=0

    repeat(k){
        arr.add(sushi[now])
        sushiKind[sushi[now]]++
        now=(now+1)%N
    }//맨처음 k크기의 그룹 구성

    while(first<N){
        var numOfSushi=arr.size

        if(sushiKind[c]==0){
            //coupon 초밥이 포함되어 있지 않을 경우
            numOfSushi+=1
        }
        if(answer<numOfSushi){
            answer=numOfSushi
        }


        // 맨 앞 초밥 빼기
        if(sushiKind[sushi[first]]>1){
            sushiKind[sushi[first]]--
        }else{
            //초밥을 하나만 포함하고 있을 경우에만 set에서 완전히 제거
            arr.remove(sushi[first])
            sushiKind[sushi[first]]--
        }


        arr.add(sushi[now])//새 초밥 넣기
        sushiKind[sushi[now]]++

        now=(now+1)%N
        first++
    }


    return answer

}

val br=System.`in`.bufferedReader()
fun main()=with(System.out.bufferedWriter()){
    var answer=0
    input= br.readLine().split(" ").map { it.toInt() }.toTypedArray()
    sushi=Array(N){0}
    sushiKind=Array(d+1){0}

    for ( i in 0 until N){
        val e= br.readLine().toInt()
        sushi[i]=e
    }
    answer=countSushi()


    write("$answer")
    close()



}
lateinit var historySizeArr:IntArray
lateinit var visit:IntArray
lateinit var studentArr:IntArray
fun main(){
    val testCaseNum= readln().toInt()
    repeat(testCaseNum){
        val studentNum= readln().toInt()
        historySizeArr=IntArray(studentNum+1){it}
        visit=IntArray(studentNum+1){0}
        var answer=studentNum
        studentArr= readln().split(" ").map { it.toInt() }.toIntArray()
        for(i in studentArr.indices){
           if(visit[i+1]==0){
               answer-=dfs(i+1,i+1,1)
           }
        }
        println(answer)

    }

}
fun dfs(now:Int,start:Int,groupSize:Int):Int{
    visit[now]=start
    historySizeArr[now]=groupSize

    val nextVisit=visit[studentArr[now-1]]
    if(now==studentArr[now-1]){
        return 1
    }//자기자신을 가리킬때 1만 return

    if(nextVisit==0){
        return dfs(studentArr[now-1],start,groupSize+1)
    }
    else if(nextVisit==start){
        //그룹을 이룸.
        return groupSize-historySizeArr[studentArr[now-1]]+1
    }else{
        return 0
    }
}


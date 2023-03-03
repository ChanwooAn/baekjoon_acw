class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
    var answer = 0
    val q=ArrayList<Pair<String,Int>>()
    //가능 리스트 찾기
    //가능 리스트들에 대해서 탐색
    //history에 현재 넣기
    q.add(Pair(begin,0))
    val history= mutableListOf<String>()
    while(q.isNotEmpty()){
        val now=q.removeFirst()
    
        history.add(now.first)
      
        
        if(now.first==target){
            answer=now.second
            break
        }
       
        val possible=findPossibleWords(now.first,history.toTypedArray(),words)
        if(possible.isEmpty()){
            continue
        }
        for(i in possible){
            q.add(Pair(i,now.second+1))
        }
        
    }

    return answer
}

//하나의 문자열이 다른경우에만 변환가능하다.
fun findPossibleWords(now:String,history:Array<String>,words:Array<String>):
        List<String>
{
    var lis=mutableListOf<String>()
    for(word in words){
        if(word.equals(now)){
            continue
        }
        if(history.contains(word)){
            continue
        }
        var count=0
        for(i in word.indices){
            if(now[i]==word[i]){
                count++
            }
        }
        if(count==word.length-1){
            lis.add(word)
        }

    }
    return lis
}
}
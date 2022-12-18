
fun main(){
    var alphaArr=Array('z'-'a'+1){false}
    var answer=0
    val n= readln().toInt()
    repeat(n){
        val word= readln()
        var groupCheck=true

        for(i in alphaArr.indices)alphaArr[i]=false

        var prevChar=word[0]
        alphaArr[prevChar-'a']=true

        for(i in word){
            if(alphaArr[i-'a'] && prevChar==i){
                continue
            }//처음보는게 아닌데, 전 문자와 같은 경우 - 계속적으로 나오는 경우

            if(alphaArr[i-'a']) {
                groupCheck=false
                break
            }// 처음보는게 아닌데 전 문자와 다른 경우- 그룹단어가 아님

            alphaArr[i-'a']=true
            prevChar=i
        }
        if(groupCheck){
            answer++
        }
    }

    println(answer)


}
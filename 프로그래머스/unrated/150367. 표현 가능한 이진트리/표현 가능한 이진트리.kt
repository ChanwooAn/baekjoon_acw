class Solution {
    var checkFlg=true
fun solution(numbers: LongArray): IntArray {
    val answer = mutableListOf<Int>()
    repeat(numbers.size){
        checkFlg=true
        val numToDigit=toBinaryNum(numbers[it])
        check(numToDigit,0,numToDigit.length-1)

        if(checkFlg){
            answer.add(1)
        }else{
            answer.add(0)
        }

    }

    return answer.toIntArray()
}
fun toBinaryNum(num:Long):String{
    var numToDigit=""
    var numDiv=num
        while(numDiv>1){
            val r=numDiv%2
            val d=numDiv/2
            numToDigit=r.toString()+numToDigit
            numDiv=d
        }
        numToDigit= "1$numToDigit"

    
        //일단 포화이진 트리로 만들기
        var multiplyer=2
        var fullTreeNum=1
    
        while(fullTreeNum<numToDigit.length){
            multiplyer*=2
            fullTreeNum=multiplyer-1
        }
        numToDigit="0".repeat(fullTreeNum-numToDigit.length)+numToDigit
    
    
    return numToDigit
    
}
fun check(num:String,start:Int,end:Int):Char{
    if(start==end){
        return num[start]
    }
    val mid=(start+end)/2
    val left=check(num,start,mid-1)
    val right=check(num,mid+1,end)
    
    if(num[mid]=='0'){
        if(left=='1' || right=='1'){
            checkFlg=false
        } 
        return '0'
    }else{
        return '1'
    }
    
}
}
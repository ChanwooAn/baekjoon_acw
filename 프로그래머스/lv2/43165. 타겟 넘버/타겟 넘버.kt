class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        
        val combArr=mutableListOf<List<Int>>()
        for(i in 1..numbers.size){
            comb(numbers,combArr,BooleanArray(numbers.size){false},0,i)
        }
        for(i in combArr){
            val s=i.sum()
            if(s==target){
                answer++
            }
        }
        /*
         양수와 음수의 모든 조합을 뽑기.
        */
        
        return answer
    }
    fun comb(numbers:IntArray,arr:MutableList<List<Int>>,visit:BooleanArray,start:Int,depth:Int)
    {
        if(depth==0){
            arr.add(numbers.mapIndexed{idx,value->
            if(visit[idx]){
                value
            }
            else{
                -value
            }
            })
        }
        
        for(i in start..numbers.size-1){
            visit[i]=true
            comb(numbers,arr,visit,i+1,depth-1)
            visit[i]=false
        }
        
    }
}
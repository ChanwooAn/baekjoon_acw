class Solution {
    var answer = 0
    lateinit var arr:IntArray
    fun solution(numbers: IntArray, target: Int): Int {
        arr=numbers
        
        dfs(0,numbers.size,0,target)
        
        return answer
    }
    fun dfs(now:Int,n:Int,sum:Int,target:Int){
        if(now==n){
            if(sum==target){
                answer++
            }
            return
        }
        
        dfs(now+1,n,sum+arr[now],target)
        dfs(now+1,n,sum-arr[now],target)
    
    }
}
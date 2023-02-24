class Solution {
    lateinit var parent:Array<Int>
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        parent=Array(computers.size){it}
        for(computer in computers.indices){
            val computerNow=computers[computer]
            for(i in computerNow.indices){
                if(i==computer){
                    continue
                }
                if(computerNow[i]==1){
                    union(i,computer)
                }
            }
        }
        
        for(i in computers.indices){
            findParent(i)
        }
        
        val parentList=mutableSetOf<Int>()
        for(i in parent){
            parentList.add(i)
        }
        answer=parentList.size
        
        return answer
    }
    
    
    fun union(a:Int,b:Int){
        val aParent=findParent(a)
        val bParent=findParent(b)
        if(aParent<bParent){
            parent[bParent]=aParent
        }else{
            parent[aParent]=bParent
        }
    }
    
    
    fun findParent(c:Int):Int{
        if(c!=parent[c]){
            parent[c]=findParent(parent[c])
        }
        
        
        return parent[c]
    }
}
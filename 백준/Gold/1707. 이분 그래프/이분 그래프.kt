val br=System.`in`.bufferedReader()


fun main(){
    val k= br.readLine().toInt()

    TestCaseLoop@for(i in 0 until k){
        val (v,e)=br.readLine().split(" ").map { it.toInt() }
        val graph=Array(v+1){ arrayListOf<Int>() }
        for(i in 0 until e){
            val (a,b)=br.readLine().split(" ").map { it.toInt() }
            graph[a].add(b)
            graph[b].add(a)
        }
        val colorArr=IntArray(v+1){0}
        for(i in 1..v){
            if(colorArr[i]==0){
                if(!dfs(i,graph,colorArr,1)){
                    println("NO")
                    continue@TestCaseLoop
                }
            }
        }
        println("YES")
    }
}

fun dfs(nodeNum:Int,graph:Array<ArrayList<Int>>,colorArr:IntArray,prevColor:Int):Boolean{
    val colorNow=-prevColor
    colorArr[nodeNum]=colorNow

    for(node in graph[nodeNum]){
        if(colorArr[node]!=0){
            if(colorArr[node]==colorNow){
                return false
            }else{
                continue
            }
        }
        if(!dfs(node,graph,colorArr,colorNow)){
            return false
        }
    }

    return true
}
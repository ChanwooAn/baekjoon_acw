lateinit var quests:Array<Array<Int>>
lateinit var comb:Array<Boolean>
var answer=0
fun makeComb(arr:MutableList<Int>,targetNum:Int,count:Int,start:Int){
    if(count==targetNum){

        for(i in 1 until 2*targetNum+1){
            if(comb[i]){
                arr.add(i)
            }
        }
        answer=answer.coerceAtLeast(countQuests(arr))
        
        arr.clear()

        return
    }

    for(i in start .. 2*targetNum){
        comb[i]=true
        makeComb(arr,targetNum,count+1,i+1)
        comb[i]=false
    }
}
fun countQuests(arr:List<Int>):Int{
    var count=0
    loop1@for(i in quests){
        for(j in i){
            if(!arr.contains(j)) {
                continue@loop1
            }
        }

        count++
    }
    return count
}
fun main(){
    val (n,m,k)=readln().split(" ").map{it.toInt()}
    quests=Array(m){readln().split(" ").map{it.toInt()}.toTypedArray()}
    comb=Array(2*n+1){false }

    makeComb(mutableListOf(),n,0,1)

    println(answer)


}
val pocketMap= hashMapOf<String,Int>()
val pocketNameList= mutableListOf<String>()
fun main(){
    val (pocketNum,problemNum)= readln().split(" ").map { it.toInt() }
    repeat(pocketNum){
        val pocketName= readln()
        pocketMap[pocketName] = it+1
        pocketNameList.add(pocketName)
    }
    repeat(problemNum){
        val problem= readln()
        if(problem in "0".."999999"){
            println(pocketNameList.get(problem.toInt()-1))
        }else{
            println(pocketMap[problem])
        }
    }

}
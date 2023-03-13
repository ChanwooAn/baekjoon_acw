val nameMap= hashMapOf<String,Int>()
fun main(){
    val (hear,see)= readln().split(" ").map { it.toInt() }
    var answer=0
    var answerNameList= mutableListOf<String>()

    repeat(hear+see){
        val name= readln()
        if(nameMap[name]==null){
            nameMap[name]=0
        }else{
            answer++
            answerNameList.add(name)
        }
    }

    println(answer)
    println(answerNameList.sorted().joinToString("\n"))

}
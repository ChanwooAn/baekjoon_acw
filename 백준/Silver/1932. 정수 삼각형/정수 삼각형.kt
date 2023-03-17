
lateinit var arr:Array<IntArray>

fun main(){
    val s= readln().toInt()
    arr=Array(s){IntArray(s){0} }
    for(i in 0 until s){
        val input= readln().split(" ").map { it.toInt() }
        for(j in input.indices){
            arr[i][j]=input[j]
        }
    }//배열구성

    for(i in 1 until s){
        for(j in 0 .. i){
            if(j==0){
                val prevMax=arr[i-1][j]
                arr[i][j]=arr[i][j]+prevMax
            }else if(j==i){
                val prevMax=arr[i-1][j-1]
                arr[i][j]=arr[i][j]+prevMax
            }else{
                val prevMax=maxOf(arr[i-1][j-1],arr[i-1][j])
                arr[i][j]=arr[i][j]+prevMax
            }
        }
    }
    var answer=arr[s-1][0]
    for(i in 0 until s){
        if(arr[s-1][i]>answer){
            answer=arr[s-1][i]
        }
    }

    println(answer)

}


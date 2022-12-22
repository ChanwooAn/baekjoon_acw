

fun main(){
    val T= readln().toInt()

    var cnt=0
    while(cnt<T){
        cnt++
        val p= readln()
        val n=readln().toInt()
        var arr= if(n>0) readln().removePrefix("[").removeSuffix("]").split(",").map{it.toInt()}
                 else arrayListOf()

        if(n==0) readln()
                
        var start=0 ; var end=arr.lastIndex
        var directionNow=true //true- 정방향 false- 역방향
        for(com in p){
            when(com){
                'R'->{
                    directionNow=!directionNow
                }
                'D'->{
                    if(directionNow){
                        start++
                    }else{
                        end--
                    }
                }
            }
        }

        if(end-start<-1){
            println("error")
            continue
        }

        if(directionNow){
            println(arr.subList(start,end+1).joinToString(",","[","]"))
        }else{
            println(arr.subList(start,end+1).reversed().joinToString(",","[","]"))
        }

    }




}

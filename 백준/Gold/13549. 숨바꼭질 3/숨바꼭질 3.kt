import java.util.LinkedList

fun main(){
    val (subin,sister)= readln().split(" ").map { it.toInt() }
    /*
    동생보다 클 경우는 무조건 뒤로만 가는게 이득.
    작은 경우에는 3가지 경우를모두 고려해야함.
    단, 동생보다 2배이상인 경우에는 의미없는 수.
     */
    val q=LinkedList<Pair<Int,Int>>()
    val visit=BooleanArray(200_001){false}
    visit[subin]=true
    q.add(Pair(subin,0))

    while(q.isNotEmpty()){
        val now=q.removeFirst()
        if(now.first==sister){
            println(now.second)
            break
        }

        if(now.first<sister){
            val nextLocations=listOf(moveBackward(now.first),moveFoward(now.first))
            val teleportLocation=teleport(now.first)

            if(!visit[teleportLocation] ){
                q.addFirst(Pair(teleportLocation,now.second))
                visit[teleportLocation]=true
            }

            for(nextLocation in nextLocations){
                if(nextLocation>-1 &&!visit[nextLocation]){
                    q.add(Pair(nextLocation,now.second+1))
                    visit[nextLocation]=true
                }
            }



        }else{
            val nextLocation=moveBackward(now.first)
            if(nextLocation>-1 &&!visit[nextLocation] ){
                q.add(Pair(nextLocation,now.second+1))
                visit[nextLocation]=true
            }
        }


    }

}

fun teleport(locationNow:Int):Int{
    return locationNow*2
}
fun moveFoward(locationNow:Int):Int{
    return locationNow+1
}
fun moveBackward(locationNow:Int):Int {
    return locationNow -1
}
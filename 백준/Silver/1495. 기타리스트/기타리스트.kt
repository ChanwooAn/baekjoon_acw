lateinit var volumList:IntArray
lateinit var dpArr:Array<BooleanArray>
fun main(){
    val(n,s,m)= readln().split(" ").map { it.toInt() }
    volumList= readln().split(" ").map { it.toInt() }.toIntArray()
    dpArr=Array(n+1){BooleanArray(m+1){false}}

    dpArr[0][s]=true

    for(song in 1 .. n){
        for(volume in 0 .. m){
            if(!dpArr[song-1][volume]){
                continue
            }
            val possibleUpperVolume=volume+volumList[song-1]
            val possibleDownVolume=volume-volumList[song-1]

            val isDownVolumePossible=possibleDownVolume>=0
            val isUpperVolumePossible=possibleUpperVolume<=m

            when{
                isDownVolumePossible && isUpperVolumePossible->{
                    dpArr[song][possibleDownVolume]=true
                    dpArr[song][possibleUpperVolume]=true
                }
                isDownVolumePossible->{
                    dpArr[song][possibleDownVolume]=true
                }
                isUpperVolumePossible->{
                    dpArr[song][possibleUpperVolume]=true
                }
                else->{
                    continue
                }
            }
        }
    }

    for(i in m downTo 0){
        if(dpArr[n][i]){
            println(i)
            return
        }
    }
    println(-1)
}

import kotlin.math.*
lateinit var populationMap:Array<IntArray>
lateinit var visit:Array<BooleanArray>

var answer=0
var least=0
var max=0
fun main(){
    val (n,l,r)=readln().split(" ").map{it.toInt()}
    least=l
    max=r
    populationMap=Array(n){readln().split(" ").map{it.toInt()}.toIntArray()}

    visit=Array(n){BooleanArray(n){false} }

    var flg=false
    do{
        flg=false
        visit=Array(n){BooleanArray(n){false} }
        for(i in 0 until visit.size){
            for(j in 0 until visit.size){
                val countryList=mutableListOf<Pair<Int,Int>>()
                if(visit[i][j]){
                    continue
                }
                dfs(i,j,countryList.apply{add(Pair(i,j))})
                if(countryList.size==1){
                    continue
                }
                val newPopulation= countryList.sumOf { populationMap[it.first][it.second] }/countryList.size
                for(country in countryList){
                    populationMap[country.first][country.second]=newPopulation
                }
                flg=true
            }
        }
        if(flg){
            answer++
        }
    }while(flg)

    println(answer)

}

val dy=listOf(1,-1,0,0)
val dx=listOf(0,0,1,-1)

fun dfs(y:Int,x:Int,countryList:MutableList<Pair<Int,Int>>){
    visit[y][x]=true

    for(i in 0 until 4){
        val ny=y+dy[i]
        val nx=x+dx[i]

        if(ny>visit.size-1||nx>visit.size-1||ny<0||nx<0){
            continue
        }
        if(visit[ny][nx]){
            continue
        }
        if(check(populationMap[y][x],populationMap[ny][nx])){
            dfs(ny,nx,countryList.apply{add(Pair(ny,nx))})
        }
    }
}



fun check(a:Int,b:Int):Boolean{
    val gap=(a-b).absoluteValue
    return gap in least..max
}
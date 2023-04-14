import kotlin.math.*

class Solution {
    /*
        일단 시작지점의 조합을 만들어야 하는데, n씩더해서 각 weak을 시작지점으로 하는 배열만들어놓기.
        그 다음, 직원의 순열을 뽑아 투입해보기
    */
    var answer=Int.MAX_VALUE
    fun solution(n: Int, weak: IntArray, dist: IntArray): Int {
        
        val allWeakCase=makeAllCase(weak,n)
        
        val allDistCase=mutableListOf<List<Int>>()
        permutation(allDistCase,dist,BooleanArray(dist.size){false},dist.size,mutableListOf())
        
        checkCase(allDistCase,allWeakCase)
        
        if(answer==Int.MAX_VALUE){
            answer=-1
        }        
        return answer
    }
    
    fun checkCase(allDistCase:List<List<Int>>,allWeakCase:Array<IntArray>,){        
        for(weakCase in allWeakCase){
            for(distCase in allDistCase){
                var pointNow=0//현재 weak위치
                loopDist@for(distNum in distCase.indices){
                    var distNow=distCase[distNum]//직원이 갈 수 있는 거리
                    while(distNow>=weakCase[pointNow+1]-weakCase[pointNow]){
                        distNow-=(weakCase[pointNow+1]-weakCase[pointNow])
                        pointNow++
                        if(pointNow==weakCase.size-1){
                            answer=minOf(answer,distNum+1)
                            break@loopDist
                        }
                    }
                    if(distNum==distCase.size-1){
                        break@loopDist
                    }//마지막 직원인데도 해결하지 못하면 바로 break
                    
                    pointNow++//이동못하면 그 지점부터 다시 시작.
                    if(pointNow==weakCase.size-1){
                        answer=minOf(answer,distNum+2)
                        break@loopDist
                    }
                }
            }
        }
        
    }
    
    
    fun permutation(allCase:MutableList<List<Int>>,dist:IntArray,visit:BooleanArray,depth:Int,lisNow:MutableList<Int>){
        if(depth==0){
            allCase.add(lisNow.toMutableList())
            return
        }
        
        for(i in dist.indices){
            if(visit[i]){
                continue
            }
            visit[i]=true
            lisNow.add(dist[i])
            permutation(allCase,dist,visit,depth-1,lisNow)
            lisNow.removeLast()
            visit[i]=false
        }
    }
    
    fun makeAllCase(weak:IntArray,n:Int):Array<IntArray>{
        val retArr=Array(weak.size){intArrayOf()}
        for(i in weak.indices){
            val arr=IntArray(weak.size){0}
            for(j in weak.indices){
                if(j<i){
                   arr[j]=weak[j]+n 
                }  
                else{
                    arr[j]=weak[j]
                }
            }
            arr.sort()
            retArr[i]=arr
        }
        return retArr
    }
}
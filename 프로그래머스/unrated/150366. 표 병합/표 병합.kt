class Solution {
    val idxArr=Array(51){y->Array(51){x->Pair(y,x)}}
    val wordArr=Array(51){Array(51){""}}

    fun solution(commands: Array<String>): Array<String> {
        val answer:MutableList<String> = mutableListOf()

        for(command in commands){
            val commandArr=command.split(" ")
            when(commandArr[0]){
                "UPDATE"->{
                    if(commandArr.size==4){
                        update(commandArr[1].toInt(),commandArr[2].toInt(),commandArr[3])
                    }else{
                        updateValue(commandArr[1],commandArr[2])
                    }
                }
                "MERGE"->{
                    merge(commandArr[1].toInt(),commandArr[2].toInt(),commandArr[3].toInt(),commandArr[4].toInt())
                }
                "UNMERGE"->{
                    unMerge(commandArr[1].toInt(),commandArr[2].toInt())
                }
                "PRINT"->{
                    answer.add(printOp(commandArr[1].toInt(),commandArr[2].toInt()))
                }
            }
        }
        
        return answer.toTypedArray()
    }

    fun getIdx(y:Int,x:Int):Pair<Int,Int>{
        if(idxArr[y][x]!=Pair(y,x)){
            idxArr[y][x]=getIdx(idxArr[y][x].first,idxArr[y][x].second)
        }
        return idxArr[y][x]
    }

    fun update(y:Int,x:Int,value:String){
        val (rY,rX)=getIdx(y,x)
        wordArr[rY][rX]=value
    }

    fun updateValue(value1:String,value2:String){
        for(i in 1 until 51){
            for(j in 1 until 51){
                if(wordArr[i][j]==value1){
                    wordArr[i][j]=value2
                }
            }
        }
    }

    fun merge(r1:Int,c1:Int,r2:Int,c2:Int){
        val (rY1,rX1)=getIdx(r1,c1)
        val (rY2,rX2)=getIdx(r2,c2)
        if(rY1==rY2 && rX1==rX2){
            return
        }//같은 셀 일 경우 무시
        
        val value1=wordArr[rY1][rX1]
        val value2=wordArr[rY2][rX2]
        val setValue=if(value1=="") value2 else value1
        wordArr[rY1][rX1]=""
        wordArr[rY2][rX2]=""

        if(rY1<rY2){
            idxArr[rY2][rX2]=Pair(rY1,rX1)
            wordArr[rY1][rX1]=setValue
        }else if(rY1==rY2){
            if(rX1<rX2){
                idxArr[rY2][rX2]=Pair(rY1,rX1)
                wordArr[rY1][rX1]=setValue
            }else{
                idxArr[rY1][rX1]=Pair(rY2,rX2)
                wordArr[rY2][rX2]=setValue
            }
        }else{
            idxArr[rY1][rX1]=Pair(rY2,rX2)
            wordArr[rY2][rX2]=setValue
        }
        
        for(i in 1 until 51){
            for(j in 1 until 51){
                getIdx(i,j)
            }
        }
    }

    fun unMerge(r:Int,c:Int){
        val (rY,rX)=getIdx(r,c)
        val prevValue=wordArr[rY][rX]
        for(i in 1 until 51){
            for(j in 1 until 51){
                if(idxArr[i][j]==Pair(rY,rX)){
                    wordArr[i][j]=""
                    idxArr[i][j]=Pair(i,j)
                }
            }
        }
        wordArr[r][c]=prevValue
    }

    fun printOp(r:Int,c:Int):String{
        val (rY,rX)=getIdx(r,c)
        return if(wordArr[rY][rX]=="") "EMPTY"
        else wordArr[rY][rX]
    }
}


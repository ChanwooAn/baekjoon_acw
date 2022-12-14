import java.util.LinkedList

class Solution {

    val recordsArr= Array(10000){ LinkedList<String>() }
    val feeArr=Array(10000){0}

    fun solution(fees: IntArray, records: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        for(i in records){
            val (time, num, inout)=i.split(" ")
            if(inout=="IN"){
                recordsArr[num.toInt()].add(time)
            }
            else{
                //out이 나올경우에는 바로 해당하는 번호에 처리를 해준다.
                val inTime=recordsArr[num.toInt()].removeLast()

                val inHM=inTime.split(":").map{it.toInt()}
                val outHM=time.split(":").map{it.toInt()}

                val usingTime=outHM[0]*60+outHM[1]-inHM[0]*60-inHM[1]
                feeArr[num.toInt()]+=usingTime
            }
        }
        //시간 넣기

        for(i in 0 until 10000){
            while(recordsArr[i].isNotEmpty()){
                val now=recordsArr[i].removeFirst().split(":").map{it.toInt()}
                val usingTime=23*60+59-now[0]*60-now[1]
                feeArr[i]+=usingTime
            }
        }


        val arr= mutableListOf<Int>()
        for(i in 0 until 10000){

            if(feeArr[i]==0){
                continue
            }

            else{

                if(feeArr[i]<=fees[0]){
                    arr.add(fees[1])
                    //기본
                }else{
                    val ceilCheck= (feeArr[i]-fees[0])%fees[2] != 0
                    var remain=if(ceilCheck){
                        (feeArr[i]-fees[0])/fees[2]+1
                    }else{
                        (feeArr[i]-fees[0])/fees[2]
                    }


                    arr.add(fees[1]+remain*fees[3])

                }
            }

        }
        answer=arr.toIntArray()


        return answer
    }


}
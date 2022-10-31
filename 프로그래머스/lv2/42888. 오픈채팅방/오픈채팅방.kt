
class Solution {
    var userList= mutableMapOf<String,String>()
    fun solution(record:Array<String>):Array<String>{
        var answer= mutableListOf<String>()

        for(i in record){
            val msg=i.split(" ")
            when(msg[0][0]){
                'C'->{
                    userList[msg[1]]=msg[2]
                }
                'E'->{
                    userList[msg[1]] =msg[2]

                }
            }
        }

        for(i in record){
            val msg=i.split(" ")
            when(msg[0][0]){
                'E'->{
                    answer.add("${userList[msg[1]]}님이 들어왔습니다.")
                }
                'L'->{
                    answer.add("${userList[msg[1]]}님이 나갔습니다.")
                }
            }
        }

        return answer.toTypedArray()
    }


}
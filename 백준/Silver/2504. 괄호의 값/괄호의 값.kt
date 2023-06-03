import java.util.*

lateinit var input: String
val st = LinkedList<Char>()

fun main() {
    input = readln().trim()

    var tmp=1
    var answer=0
    for(i in input.indices){
        when(input[i]){
            '('->{
                st.add('(')
                tmp*=2
            }
            '['->{
                st.add('[')
                tmp*=3
            }
            ']'->{
                if(st.isEmpty()||st.last!='['){
                    answer=0
                    break
                }
                if(input[i-1]=='['){
                    answer+=tmp
                }
                st.removeLast()
                tmp/=3
            }
            ')'->{
                if(st.isEmpty()||st.last!='('){
                    answer=0
                    break
                }
                if(input[i-1]=='('){
                    answer+=tmp
                }
                st.removeLast()
                tmp/=2
            }
        }


    }

    if(st.isEmpty()){
        println(answer)
    }else{
        println(0)
    }
}
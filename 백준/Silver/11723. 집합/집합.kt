enum class ListCommand {
    ADD, REMOVE, CHECK, TOGGLE, ALL, EMPTY
}

class MyList {
    private val list = Array(21){0}

    fun execute(command: ListCommand, num: Int?) {
        when (command) {
            ListCommand.ADD -> {
                if (num != null) {
                    if(list[num]==0){
                        list[num]=1
                    }
                }
            }
            ListCommand.REMOVE -> {
                if (num != null) {
                    if(list[num]==1){
                        list[num]=0
                    }
                }
            }
            ListCommand.CHECK -> {
                bw.write(if (num != null && list[num]==1) "1\n" else "0\n")
            }
            ListCommand.TOGGLE -> {
                if (num != null) {
                    if (list[num]==1) {
                        list[num]=0
                    } else {
                        list[num]=1
                    }
                }
            }
            ListCommand.ALL -> {
                for(i in 1..20){
                    list[i]=1
                }
            }
            ListCommand.EMPTY -> {
                for(i in 1..20){
                    list[i]=0
                }
            }
        }
    }
}
val br = System.`in`.bufferedReader()
val bw = System.`out`.bufferedWriter()
fun main() {
    val myList = MyList()
    val numOfCal = readln().toInt()

    repeat(numOfCal) {
        val input = br.readLine().split(" ")
        val command = input.first()
        val num = input.getOrNull(1)?.toInt()
        myList.execute(ListCommand.valueOf(command.uppercase()), num)
    }
    bw.close()
    br.close()

}

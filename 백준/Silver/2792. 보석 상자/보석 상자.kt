lateinit var beadArr: IntArray

fun main() {
    val (childNum, colorNum) = readln().split(" ").map { it.toInt() }
    beadArr = IntArray(colorNum) { readln().toInt() }

    var start = 1
    var end = beadArr.max()
    var distributeQuantity = (start+end)/2
    var answer=-1

    while (start<=end) {
        if (distributable(distributeQuantity,childNum)) {
            end=distributeQuantity-1
            answer=distributeQuantity
        }//가능하다면 크기 줄이기
        else {
            start=distributeQuantity+1
        }//불가능하면 크기 키우기

        distributeQuantity=(start+end)/2
    }

    println(answer)
}

fun distributable(size: Int,childNum:Int): Boolean {
    var leftChildNum=childNum
    for(beadNum in beadArr){
        var now=beadNum
        while(now>size){
            leftChildNum--
            now-=size
        }
        if(now>0){
            leftChildNum--
        }
    }

    return leftChildNum>=0
}


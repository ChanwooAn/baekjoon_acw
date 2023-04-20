
lateinit var inOrder:IntArray
lateinit var inOrderIdx:IntArray//inorder node들의 순서를 저장할 배열
lateinit var postOrder:IntArray
val preOrder= mutableListOf<Int>()
fun main(){
    val n=readln().toInt()
    inOrderIdx=IntArray(n+1){0}
    postOrder=IntArray(n+1){0}

    inOrder= readln().split(" ").map { it.toInt() }.toIntArray()
    for(i in inOrder.indices){
        inOrderIdx[inOrder[i]]=i
    }

    postOrder= readln().split(" ").map{it.toInt()}.toIntArray()
    recursivePreOrder(0,n-1,0,n-1)
    println(preOrder.joinToString(" "))
}
/*
재귀는 inOrder를 기준으로 진행되며, inOrder의 root를 기준으로 왼쪽과 오른쪽으로 나누어 재귀적으로 들어간다.
 */
fun recursivePreOrder(inOrderStart:Int,inOrderEnd:Int,postOrderStart:Int,postOrderEnd:Int){
    if(inOrderStart>inOrderEnd||postOrderStart>postOrderEnd){
        return
    }
    val rootIdx=inOrderIdx[postOrder[postOrderEnd]]//postOrder의 마지막 node는 root노드이다. root노드의 idx를 얻는다.
    val leftSize=rootIdx-inOrderStart
    val rightSize=inOrderEnd-rootIdx
    preOrder.add(inOrder[rootIdx])//preOrder는 rootidx를 먼저 출력해야함으로 출력

    recursivePreOrder(inOrderStart,rootIdx-1,postOrderStart,postOrderStart+leftSize-1)
    recursivePreOrder(rootIdx+1,inOrderEnd,postOrderStart+leftSize,postOrderEnd-1)
}
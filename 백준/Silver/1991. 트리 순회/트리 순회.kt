

val nodeMap= mutableMapOf<String,Node>()
data class Node(var myName:String,var left:String,var right:String)
fun main(){
    val nodeNum= readln().toInt()
    repeat(nodeNum){
        val (p,l,r)= readln().split(" ")
        nodeMap.put(p,Node(p,l,r))
    }
    preorder("A")
    println()

    inorder("A")
    println()

    postorder("A")
    println()

}

fun preorder(nodeName:String){
    //왼쪽자식부터
    if(nodeName=="."){
        return
    }
    print(nodeName)
    preorder(nodeMap[nodeName]!!.left)
    preorder(nodeMap[nodeName]!!.right)

}
fun inorder(nodeName:String){
    val nodeNow=nodeMap[nodeName]!!
    if(nodeNow.left!="."){
        inorder(nodeNow.left)
    }
    print(nodeName)
    if(nodeNow.right!="."){
        inorder(nodeNow.right)
    }

}
fun postorder(nodeName:String){
    val nodeNow=nodeMap[nodeName]!!
    if(nodeNow.left!="."){
        postorder(nodeNow.left)
    }
    if(nodeNow.right!="."){
        postorder(nodeNow.right)
    }
    print(nodeName)

}
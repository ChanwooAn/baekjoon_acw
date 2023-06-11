
fun merge(sortedArr: IntArray,arr: IntArray,left: Int,right: Int){
    var k=left
    var li=left
    val mid=(left+right)/2
    var ri=mid+1

    while(li<=mid && ri<=right){
        if(arr[li]<arr[ri]){
            sortedArr[k++]=arr[li++]
        }else{
            sortedArr[k++]=arr[ri++]
        }
    }//작은거부터 sorted에 채워넣기

    while(li<=mid){
        sortedArr[k++]=arr[li++]
    }//오른쪽이 먼저 다 채워졌을 경우 남은 왼쪽것들 채워주기

    while(ri<=right){
        sortedArr[k++]=arr[ri++]
    }//왼쪽이 먼저 다 채워졌을 경우 남은 오른쪽 채워주기

    for(i in left..right){
        arr[i]=sortedArr[i]
    }
}
fun mergeSort(sortedArr:IntArray,arr:IntArray,left:Int,right:Int){
    if(left<right){
        val mid=(left+right)/2
        mergeSort(sortedArr,arr,left,mid)
        mergeSort(sortedArr,arr,mid+1,right)
        merge(sortedArr,arr,left,right)
    }
}

val br=System.`in`.bufferedReader()
val bw=System.`out`.bufferedWriter()
lateinit var arr:IntArray
lateinit var sortedArr:IntArray
fun main(){
    val n=br.readLine().toInt()
    arr=IntArray(n){0}
    sortedArr=IntArray(n){0}
    repeat(n){
        arr[it]=br.readLine().toInt()
        sortedArr[it]=arr[it]
    }
    mergeSort(sortedArr,arr,0,n-1)

    for(num in sortedArr){
        bw.write("$num\n")
    }

    br.close()
    bw.close()
}
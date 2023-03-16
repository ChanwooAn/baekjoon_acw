
lateinit var arr:Array<IntArray>
lateinit var prefixArr:Array<IntArray>

val br = System.`in`.bufferedReader()
val bw = System.`out`.bufferedWriter()
fun main(){
    val (n,m)=readln().split(" ").map { it.toInt() }
    arr=Array(n){ readln().split(" ").map { it.toInt() }.toIntArray() }
    prefixArr=Array(n){ IntArray(n){0} }
    makePrefix(n)
    repeat(m){
        val(y1,x1,y2,x2)= br.readLine().split(" ").map{it.toInt()-1}
        if(x1==0 && y1==0){
            bw.write("${prefixArr[y2][x2]}\n")
        }else if(y1==0){
            bw.write("${prefixArr[y2][x2]-prefixArr[y2][x1-1]}\n")
        }else if(x1==0){
            bw.write("${prefixArr[y2][x2]-prefixArr[y1-1][x2]}\n")
        }else{
            bw.write("${prefixArr[y2][x2]-prefixArr[y2][x1-1]-prefixArr[y1-1][x2]+prefixArr[y1-1][x1-1]}\n")
        }
    }
    br.close()
    bw.close()


}
fun makePrefix(n:Int){
    prefixArr[0][0] =arr[0][0]
    for(y in 0 until n){
        for(x in 0 until n){
            //y보다 같거나 작은 y들에 대해서, x보다 작은 x들에 대해서.
            if(y==0&& x==0){
                continue
            }
            if(y-1<0){
                prefixArr[y][x]=prefixArr[y][x-1]+arr[y][x]
            }else if(x-1<0){
                prefixArr[y][x]=prefixArr[y-1][x]+arr[y][x]
            }else{
                prefixArr[y][x]=prefixArr[y-1][x]+prefixArr[y][x-1]+arr[y][x]-prefixArr[y-1][x-1]
            }
        }
    }
}
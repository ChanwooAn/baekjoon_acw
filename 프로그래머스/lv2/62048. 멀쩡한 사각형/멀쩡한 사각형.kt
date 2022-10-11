class Solution {
    fun gcd(a:Int,b:Int):Int=if(b!=0)gcd(b,a%b) else a
    
    fun solution(w: Int, h: Int): Long {
        var answer: Long = 0
        val g=gcd(w,h)
        val width=w.toLong()
        val height=h.toLong()

        answer=width*height-(width+height-g)


        return answer
    }
}
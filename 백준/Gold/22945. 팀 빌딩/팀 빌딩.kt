import java.lang.Integer.min
import kotlin.math.max
  fun main() {
        val n = readln().toInt()
        val arr = readln().split(" ").map{it.toInt()}

        var l = 0
        var r = n - 1
        var ans = 0
        while (l <= r) {
            val min = min(arr[l], arr[r])
            ans = max((r - l - 1) * min, ans)
            if (arr[l] < arr[r]) {
                l++
            } else {
                r--
            }
        }
        println(ans)
    }

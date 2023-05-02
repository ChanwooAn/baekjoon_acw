
class Solution {
     
   val discounts = listOf(10, 20, 30, 40)
   var answer = listOf(-1, -1)

fun solution(users: Array<IntArray>, emoticons: IntArray): List<Int> {
    val n = users.size
    val m = emoticons.size
    val discountList = MutableList(m) { 0 }

    fun search(idx: Int) {
        if (idx == m) {
            var saleNum = 0
            var costNum = 0
            for (i in 0 until n) {
                var tmp = 0
                for (j in 0 until m) {
                    if (users[i][0] <= discountList[j]) {
                        tmp += emoticons[j] * (100 - discountList[j]) / 100
                    }
                }
                if (tmp >= users[i][1]) {
                    saleNum += 1
                } else {
                    costNum += tmp
                }
            }
            if (saleNum > answer[0] || saleNum == answer[0] && costNum > answer[1]) {
                answer = listOf(saleNum, costNum)
            }
            return
        }

        for (i in 0 until 4) {
            discountList[idx] = discounts[i]
            search(idx + 1)
        }
    }

    search(0)

    return answer
}

    
    
    
}

/*
가입자를 최대한 늘려야 한다.
할인율은 최저로 하면서 가입자는 최대한 늘려야한다.
할인율을 늘렸을 때, 가입자가 늘어날 확률은 없다.
할인율을 늘렸을 때, 판매액이 커질 확률은 존재한다.
*/
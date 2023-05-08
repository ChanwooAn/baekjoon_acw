data class City(val cost: Int, val expectCustomerNum: Int)

lateinit var infoArr: Array<City>
lateinit var dpArr: IntArray
fun main() {
    val (targetCustomerNum, cityNum) = readln().split(" ").map { it.toInt() }
    infoArr = Array(cityNum) {
        val (cost, expectedExtraCustomer) = readln().split(" ").map { it.toInt() }
        City(cost, expectedExtraCustomer)
    }
    dpArr = IntArray(100001) { 0 }

    for (marketingInfo in infoArr) {
        var costNow=0
        while(costNow<100001 && dpArr[costNow]<targetCustomerNum ){
            if(marketingInfo.cost<=costNow){
                dpArr[costNow]=maxOf(dpArr[costNow],dpArr[costNow-marketingInfo.cost]+marketingInfo.expectCustomerNum)
            }
            costNow++
        }
    }
    for(cost in 1..100000){
        if(dpArr[cost]>=targetCustomerNum){
            println(cost)
            break
        }
    }
}

/*
cost의 최대값
100 1 일 경우
1000명을 만들기 위해 100000이 필요
 */
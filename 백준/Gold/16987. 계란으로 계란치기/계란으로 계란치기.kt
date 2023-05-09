import kotlin.math.max

data class Egg(var durability: Int, val weight: Int, var isCrashed: Boolean) {
    fun bump(otherEgg: Egg) {
        this.durability -= otherEgg.weight
        if (this.durability <= 0) {
            this.isCrashed = true
        }
    }

    fun restore(otherEgg: Egg) {
        this.durability += otherEgg.weight
        if (this.durability > 0) {
            this.isCrashed = false
        }
    }
}

lateinit var eggArr: Array<Egg>
var answer = 0

fun main() {
    val eggNum = readLine()!!.toInt()
    eggArr = Array(eggNum) {
        val egg = readLine()!!.split(" ").map { it.toInt() }
        Egg(egg[0], egg[1], false)
    }

    if (eggNum == 1) {
        println(0)
        return
    }

    dfs(0, 0)
    println(answer)

}

fun dfs(now: Int, crashNum: Int) {
    if (now >= eggArr.size) {
        answer = max(answer, crashNum)
        return
    }

    if (eggArr[now].isCrashed) {
        dfs(now + 1, crashNum)
        return
    }

    var hasTarget = false
    for (i in eggArr.indices) {
        if (eggArr[i].isCrashed || i == now) {
            continue
        }

        hasTarget = true
        eggArr[now].bump(eggArr[i])
        eggArr[i].bump(eggArr[now])
        val crashCnt = when {
            eggArr[now].isCrashed && eggArr[i].isCrashed -> {
                2
            }
            eggArr[now].isCrashed || eggArr[i].isCrashed -> {
                1
            }
            else -> {
                0
            }
        }
        dfs(now + 1, crashNum + crashCnt)
        eggArr[now].restore(eggArr[i])
        eggArr[i].restore(eggArr[now])
    }

    if (!hasTarget) {
        dfs(now + 1, crashNum)
    }
}
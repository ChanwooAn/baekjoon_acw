
val dy = listOf(
    listOf(-1, -1, 0, 0, 1, 1),//even
    listOf(-1, -1, 0, 0, 1, 1)//odd
    //-> 왼위/오위/왼/오/오아/왼아

)
val dx = listOf(
    listOf(0, 1, -1, 1, 0, 1),
    listOf(-1, 0, -1, 1, -1, 0)
)

const val OUTSIDE = 6


//6각형 인접
var width = 0
var height = 0
var answer = 0
lateinit var buildings: Array<IntArray>
lateinit var visit: Array<Array<Array<Boolean>>>

fun main() {
    val (w, h) = readln().trim().split(" ").map { it.toInt() }
    buildings = Array(h) { readln().trim().split(" ").map { it.toInt() }.toIntArray() }
    visit = Array(h) { Array(w) { Array(6) { false } } }

    width = w
    height = h

    for (x in 0 until w) {
        if (buildings[0][x] == 0) {
            findOutSide(0, x)
        }
    }
    for (x in 0 until w) {
        if (buildings[h - 1][x] == 0) {
            findOutSide(h - 1, x)
        }
    }
    for (y in 0 until h) {
        if (buildings[y][0] == 0) {
            findOutSide(y, 0)
        }
    }
    for (y in 0 until h) {
        if (buildings[y][w - 1] == 0) {
            findOutSide(y, w - 1)
        }
    }



    for (y in 0 until h) {
        for (x in 0 until w) {
            if (buildings[y][x] > 0) {
                bfs(y, x)
            }
        }
    }//건물의 선을 찾는다.


    println(answer)

}


fun findOutSide(nowY: Int, nowX: Int) {

    val d = if (nowY % 2 == 0) 0 else 1
    for (i in 0 until 6) {

        val ny = nowY + dy[d][i]
        val nx = nowX + dx[d][i]
        if (visit[nowY][nowX][i]) {
            continue
        }

        if (ny < 0 || nx < 0 || ny >= height || nx >= width) {
            visit[nowY][nowX][i] = true
            continue
        }

        if (buildings[ny][nx] > 0) {
            //빌딩이라면
            buildings[nowY][nowX] = OUTSIDE
            visit[nowY][nowX][i] = true
            continue
        }

        buildings[nowY][nowX] = OUTSIDE
        visit[nowY][nowX][i] = true
        visit[ny][nx][5 - i] = true
        findOutSide(ny, nx)
    }


}

fun bfs(nowY: Int, nowX: Int) {


    val d = if (nowY % 2 == 0) 0 else 1
    for (i in 0 until 6) {

        val ny = nowY + dy[d][i]
        val nx = nowX + dx[d][i]
        if (visit[nowY][nowX][i]) {
            continue
        }


        if (ny < 0 || nx < 0 || ny >= height || nx >= width) {
            answer++
            visit[nowY][nowX][i] = true
            continue
        }//외부와 만나거나
        if (buildings[ny][nx] == OUTSIDE) {
            answer++
            visit[nowY][nowX][i] = true
            continue
        }//외벽과 만날 경우


        visit[nowY][nowX][i] = true
        visit[ny][nx][5 - i] = true
        bfs(ny,nx)
    }


}
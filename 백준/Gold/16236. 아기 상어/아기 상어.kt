
lateinit var m:Array<Array<Int>>
lateinit var visits:Array<Array<Boolean>>


var q= arrayListOf<Triple<Int,Int,Int>>()

val dx= arrayOf(0,-1,1,0)
val dy= arrayOf(-1,0,0,1)
var answer=0
var sizeOfShark=2
var fishEaten=0
var foods=0

fun main(args: Array<String>){
    var x=0; var y=0
    val N= readln().toInt()
    m=Array(N){Array(N){0} }
    visits=Array(N){Array(N){false}}

    for(i in 0 until N){
        m[i]= readln().split(" ").map { it.toInt() }.toTypedArray()
    }

    for(i in 0 until N){
        for(j in 0 until N){
            if(m[i][j]==9){
                y=i
                x=j
            }else if(m[i][j]>0){
                foods++
            }
        }
    }

    q.add(Triple(y,x,0))
    visits[y][x]=true
    m[y][x]=0



    var nx=0;var ny=0;
    var cost=0;
    var ex=100; var ey=100; var costExpected=100

    while(foods>0){
        if(q.isEmpty()){
            if(ey!=100){
                y=ey
                x=ex
                cost=costExpected


                m[y][x]=0
                foods--
                fishEaten++

                if(fishEaten==sizeOfShark){
                    sizeOfShark++
                    fishEaten=0
                    //상어 size up
                }

                q = arrayListOf()
                q.add(Triple(y,x,0))

                visits=Array(N){Array(N){false}}
                visits[y][x]=true

                answer+=(cost)

                ey=100
                ex=100
                costExpected=100
            }
            else{
                break
            }
        }
        else{
            y=q.first().first
            x=q.first().second
            cost=q.first().third
            q.removeFirst()

            if(ey!=100 && costExpected!=cost){

                y=ey
                x=ex
                cost=costExpected


                m[y][x]=0
                foods--
                fishEaten++

                if(fishEaten==sizeOfShark){
                    sizeOfShark++
                    fishEaten=0
                    //상어 size up
                }

                q = arrayListOf()

                visits=Array(N){Array(N){false}}
                visits[y][x]=true

                answer+=(cost)
                cost=0

                ey=100
                ex=100
                costExpected=100
            }

            if(m[y][x] in 1 until sizeOfShark){

                if(y<ey){
                    ey=y
                    ex=x
                    costExpected=cost
                }else if(y==ey && x<ex){
                    ey=y
                    ex=x
                    costExpected=cost
                }

            }

            for(i in 0 until 4){
                nx=x+dx[i]
                ny=y+dy[i]

                if(nx<0||ny<0||nx>=N||ny>=N){
                    continue
                }
                if(visits[ny][nx]){
                    continue
                }

                if(m[ny][nx]>sizeOfShark){
                    continue
                }
                else if(m[ny][nx]<=sizeOfShark || m[ny][nx]>=0){
                    q.add(Triple(ny,nx,cost+1))
                    visits[ny][nx]=true
                }


            }




        }



    }



    println(answer)




}
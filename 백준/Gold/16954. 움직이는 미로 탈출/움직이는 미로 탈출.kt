data class Node(val x: Int, val y: Int, val time:Int)

val board = Array(9){Array(8){ CharArray(8) }}
val dx = intArrayOf(-1,1,0,0, 1,-1,1,-1, 0)
val dy = intArrayOf(0,0,-1,1, 1,1,-1,-1, 0)

fun bfs(start:Node):Int {
    val q = ArrayDeque<Node>()
    q.addLast(start)
    val chk = Array(8){Array(8){ BooleanArray(8){ false } }}
    chk[0][start.x][start.y] = true
    while(q.isNotEmpty()){
        val cur = q.removeFirst()
        
        if (cur.time >= 7) return 1

        for (i in 0..8){
            val nx = cur.x + dx[i]
            val ny = cur.y + dy[i]
            val nt = minOf(7, cur.time + 1)
            if (nx !in 0..7 || ny !in 0..7) continue
            if(chk[nt][nx][ny] || board[cur.time][nx][ny] == '#' || board[nt][nx][ny] == '#') continue
            q.addLast(Node(nx, ny, nt))
            chk[nt][nx][ny] = true
        }
    }

    return 0
}

fun main() {
    val br = System.`in`.bufferedReader()

    for(i in 0..7){
        board[0][i] = br.readLine().toCharArray()
    }

    for (t in 1..8) {
        for (row in 7 downTo 1) {
            board[t][row] = board[t - 1][row - 1].clone()
        }

        board[t][0] = CharArray(8) { '.' }
    }

    println(bfs(Node(7,0,0)))
}

//bfs 돌리다가 벽을 만난 노드는 즉시 종료 및 0반환
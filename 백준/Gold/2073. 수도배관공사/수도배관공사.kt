import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

data class Pipe(val l: Int, val c: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val d = st.nextToken().toInt()
    val p = st.nextToken().toInt()
    val pipes = Array<Pipe>(p){ Pipe(0,0) }
    for(i in 0 until p){
        st = StringTokenizer(br.readLine())
        val l = st.nextToken().toInt()
        val c = st.nextToken().toInt()
        pipes[i] = Pipe(l, c)
    }
    val dp = IntArray(d+1){ 0 }
    dp[0] = Int.MAX_VALUE
    for(i in 0 until p){
        val cur = pipes[i]
        for(j in d downTo  cur.l){
            if(dp[j-cur.l]!=0){
                dp[j] = max(dp[j], min(dp[j-cur.l], cur.c))
            }
        }
    }
    print(dp[d])
}
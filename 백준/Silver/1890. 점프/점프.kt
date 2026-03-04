import java.util.StringTokenizer

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) {IntArray(n)}

    for (i in 0 until n){
        val st = StringTokenizer(br.readLine())
        for (j in 0 until n) {
            arr[i][j] = st.nextToken().toInt()
        }
    }

    val dp = Array(n){LongArray(n)}
    dp[0][0] = 1L

    for (i in 0 until n){
        for (j in 0 until n){
            if (dp[i][j] == 0L || (i == n - 1 && j == n - 1)) continue

            val jump = arr[i][j]

            if (i + jump < n){
                dp[i + jump][j] += dp[i][j]
            }

            if (j + jump < n){
                dp[i][j + jump] += dp[i][j]
            }
        }
    }

    print(dp[n - 1][n - 1])
}
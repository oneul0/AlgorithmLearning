fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        val blank = " ".repeat(n - 1 - i)
        val star = "*".repeat(2 * i + 1)
        println(blank + star)
    }
}
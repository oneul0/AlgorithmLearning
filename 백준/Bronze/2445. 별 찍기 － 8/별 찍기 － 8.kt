fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    for (i in 1 until n) {
        val blank = " ".repeat(((n - i) * 2))
        val len = ((n * 2) - blank.length) / 2
        println("*".repeat(len) + blank + "*".repeat(len))
    }
    for (i in n downTo  1) {
        val blank = " ".repeat(((n - i) * 2))
        val len = ((n * 2) - blank.length) / 2
        println("*".repeat(len) + blank + "*".repeat(len))
    }
}
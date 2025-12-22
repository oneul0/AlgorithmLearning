fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    for(i in 1 until n){
        val blank = " ".repeat(i-1)
        val star = "*".repeat((n-i)*2+1)
        println(blank+star)
    }
    for(i in n downTo 1){
        val blank = " ".repeat(i-1)
        val star = "*".repeat((n-i)*2+1)
        println(blank+star)
    }
}
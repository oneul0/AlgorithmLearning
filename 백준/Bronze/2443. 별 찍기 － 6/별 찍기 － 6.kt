fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    for(i in 0 until n){
        println(" ".repeat(i)+"*".repeat(2*(n-i-1)+1))
    }
}
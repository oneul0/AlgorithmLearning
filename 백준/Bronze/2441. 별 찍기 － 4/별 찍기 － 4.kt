fun main(){
    val br = System.`in`.bufferedReader()
    val N = br.readLine().toInt()
    for(i in 0 ..N-1){
        println(" ".repeat(i) + "*".repeat(N-i))
    }
}
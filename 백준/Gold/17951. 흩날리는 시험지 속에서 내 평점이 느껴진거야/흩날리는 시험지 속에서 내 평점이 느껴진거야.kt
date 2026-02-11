import java.util.StringTokenizer

fun main(){
    val br = System.`in`.bufferedReader()
    var st = StringTokenizer(br.readLine())
    val n = st.nextToken().toInt()
    val k = st.nextToken().toInt()

    st = StringTokenizer(br.readLine())
    val papers = IntArray(n)
    var sum = 0L
    for(i in 0..n-1){
        papers[i] = st.nextToken().toInt()
        sum+=papers[i]
    }

    print(getMaxScore(papers, k, sum))
}

fun getMaxScore(papers: IntArray, k: Int, sum: Long): Long{
    var low = 0L
    var high = sum
    var ans = 0L
    while(low <= high){
        val mid = (low + high) ushr 1 //unsigned shift right
        if(canDivide(papers, k, mid)){
            ans = mid
            low = mid+1
        }
        else{
            high = mid-1
        }
    }
    return ans
}

fun canDivide(papers: IntArray, k: Int, target: Long): Boolean{
    var curSum = 0L
    var cnt = 0
    for(i in 0 until papers.size){
        curSum += papers[i]
        if(curSum >= target){
            curSum = 0L
            cnt++
        }
    }
    return cnt >= k
}
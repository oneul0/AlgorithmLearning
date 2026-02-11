import java.util.StringTokenizer
import kotlin.math.max

data class Transaction(val amount: Long, val deposit: Long)

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var st: StringTokenizer
    val transactions = Array(n) { Transaction(0L, 0L) }
    for(i in 0 until n){
        st = StringTokenizer(br.readLine())
        transactions[i] = Transaction(
            st.nextToken().toLong(),
            st.nextToken().toLong()
        )
    }

    //트랜잭션 추리기
    var y = 0L
    var maxBalance = 0L
    val transactionSet = mutableListOf<Long>()

    for(i in 0 until n){
        val m = transactions[i].amount
        val t = transactions[i].deposit
        //y < -m 인 경우만 추출
        if(y < -m){
            transactionSet.add(t-m-y)
            maxBalance = max(maxBalance, t)
        }
        else{
            //이 경우가 아닌데(충전 안 하는데) y+m != t 이면 안됨
            if(y+m != t){
                print(-1)
                return
            }
        }
        y = t
    }


    //트랜잭션의 GCD구하기
    val x = solve(transactionSet)
    if(transactionSet.isEmpty()){
        //충전이 필요없는 경우 최충금 1로 반환
        print(1)
    }
    else {
        if(x <= maxBalance){
            print(-1)
        }
        else{
            print(x)
        }
    }
}

fun solve(charged: MutableList<Long>): Long{
    //충전된 금액(t-m-y)의 최대공약수 구하기
    var x = 0L
    for(i in 0 until charged.size){
        if(x == 0L) x = charged[i]
        else x = getGcd(x, charged[i])
    }
    return x
}

fun getGcd(v1: Long, v2:Long): Long{
    var a = v1
    var b = v2
    while(b > 0){
        val tmp = a%b
        a = b
        b = tmp
    }
    return a
}
//최소 출금 단위 x 가 존재할 때, 충전 횟수 n,
//입출금 금액 m, 카카오페이 잔고t 가 주어진다.
//이때, 이번 트랜잭션 이전의 잔고 y라고 할 때

// 1500 1500
//-17000 4500

// 4500 = (1500 + x*n) + -17000
// t = (y + x*n) + m
// t-m = y + x*n
//(t-m-y)/n = x 를 충족해야함
//(t-m-y)/x = n
//따라서 이전의 x1*n1 과 xi-1*ni-1간의 공약수 중 아무거나 구하기

//트랜잭션 추리기 : y+m >= 0인 것들로만 충전이 필요한 것들로만
//구한 트랜잭션 세트(t-m-y)들의 GCD(최대공약수) 구하기
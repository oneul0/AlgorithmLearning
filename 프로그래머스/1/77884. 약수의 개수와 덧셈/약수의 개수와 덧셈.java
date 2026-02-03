class Solution {
    boolean[] chk = new boolean[1001];
    public int solution(int left, int right) {
        int answer = 0;
        for(int idx = left; idx<=right; idx++){
            int divisorCnt = getDivisor(idx);
            if(divisorCnt % 2== 0) answer += idx;
            else answer -= idx;
        }
        return answer;
    }
    public int getDivisor(int num){
        int cnt = 0;
        for(int i = 1; i<=num; i++){
            if(num % i == 0) cnt++;
        }
        return cnt;
    }
}
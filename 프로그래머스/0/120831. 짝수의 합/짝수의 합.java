class Solution {
    public int solution(int n) {
        int answer = 0;
        int val = 2;
        while(val <= n){
            answer += val;
            val+=2;
        }
        return answer;
    }
}
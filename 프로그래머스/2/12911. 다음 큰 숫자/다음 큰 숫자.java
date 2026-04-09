class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = n+1; i<=1_000_000; i++){
            if(Integer.bitCount(n) == Integer.bitCount(i)) return i;
        }
        return answer;
    }
}
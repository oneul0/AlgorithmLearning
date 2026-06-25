class Solution {
    public int solution(int hp) {
        int answer = 0;
        int i = 5;
        while(hp>0 && i>0){
            answer += hp/i;
            hp %= i;
            i-=2;
        }
        return answer;
    }
}
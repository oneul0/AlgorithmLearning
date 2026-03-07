class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a){
            int result = (n/a)*b;
            int left = n%a;
            answer+=result;
            n = result + left;
        }
        return answer;
    }
}

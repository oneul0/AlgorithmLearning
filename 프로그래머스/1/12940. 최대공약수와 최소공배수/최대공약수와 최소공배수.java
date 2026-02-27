class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(Math.max(n, m), Math.min(n,m));
        answer[1] = lcm(n, m, answer[0]);
        return answer;
    }
    
    public int lcm(int a, int b, int g){
        return (a*b)/g;
    }
    
    public int gcd(int a, int b){
        while(b>0){
            int tmp = a;
            a = b;
            b = tmp%b;
        }
        return a;
    }
}
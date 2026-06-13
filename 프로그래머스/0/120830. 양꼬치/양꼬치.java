class Solution {
    public int solution(int n, int k) {
        return (n*12000)+(k*2000)-((n<10 ? 0 : n/10)*2000);
    }
}
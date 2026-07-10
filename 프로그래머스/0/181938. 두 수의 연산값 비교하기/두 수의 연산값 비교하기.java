class Solution {
    public int solution(int a, int b) {
        int calc = Integer.parseInt(String.valueOf(a)+b);
        return calc >= 2*a*b ? calc : 2*a*b;
    }
}
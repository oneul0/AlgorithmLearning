class Solution {
    public int solution(int a, int b) {
        String sa = String.valueOf(a);
        String sb = String.valueOf(b);
        return Math.max(Integer.parseInt(sa+sb), Integer.parseInt(sb+sa));
    }
}
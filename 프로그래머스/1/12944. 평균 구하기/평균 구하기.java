class Solution {
    public double solution(int[] arr) {
        int tmp = 0;
        for(int n : arr) tmp+=n;
        return  (double) tmp / arr.length;
    }
}
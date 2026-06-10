class Solution {
    public int largestAltitude(int[] gain) {
        int val= 0;
        int maxVal = 0;
        for(int i : gain){
            val += i;
            maxVal = Math.max(val, maxVal);
        }
        return maxVal;
    }
}
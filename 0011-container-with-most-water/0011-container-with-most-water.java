class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int max = 0;
        while(l<r){
            int w = (r-l) * Math.min(height[r], height[l]);
            max = Math.max(w, max);
            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
        }

        return max;
    }
}
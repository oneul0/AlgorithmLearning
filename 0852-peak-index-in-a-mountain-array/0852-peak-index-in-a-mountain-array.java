class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int val = -1;
        int idx = -1;
        for(int i = 0; i<arr.length; i++){
            if(val < arr[i]){
                val = arr[i];
                idx = i;
            }
        }
        return idx;
    }
}
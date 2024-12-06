class Solution {
    int[] diffs, times;
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        int left = 1;
        int right = 100000;
        
        if(canSolve(left, limit)) return 1;
        
        while (left+1 < right) {
            int mid = (left + right) / 2;

            if (canSolve(mid, limit)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
    }

    private boolean canSolve(int level, long limit) {
        long totalTime = times[0];
        for (int i = 1; i < diffs.length; i++) {
            if(diffs[i] > level) totalTime += ((times[i] + times[i - 1]) * (diffs[i] - level)) + times[i];
            else totalTime += times[i];
            
            if (totalTime > limit) return false;
        }
        return true;
    }
}
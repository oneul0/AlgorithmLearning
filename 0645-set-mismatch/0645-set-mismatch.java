class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n+1];

        for (int num : nums) {
            cnt[num]++;
        }

        int duplicate = 0;
        int missing = 0;

        for (int i=1; i<=n; i++) {
            if (cnt[i] == 2) duplicate = i;
            if (cnt[i] == 0) missing = i;
        }

        return new int[]{duplicate, missing};
    }
}
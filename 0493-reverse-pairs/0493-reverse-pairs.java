class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] tmp = new int[nums.length];
        return mergeSort(nums, tmp, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int[] tmp, int left, int right) {
        if (left >= right) {
            return 0;
        }

        int mid = left + (right - left) / 2;

        int count = 0;
        count += mergeSort(nums, tmp, left, mid);
        count += mergeSort(nums, tmp, mid + 1, right);

        // 왼쪽 구간과 오른쪽 구간 사이의 reverse pair 개수 세기
        int j = mid + 1;

        for (int i = left; i <= mid; i++) {
            while (j <= right && (long) nums[i] > 2L * nums[j]) {
                j++;
            }

            count += j - (mid + 1);
        }

        // 정렬된 두 구간 merge
        merge(nums, tmp, left, mid, right);

        return count;
    }

    private void merge(int[] nums, int[] tmp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                tmp[k] = nums[i];
                i++;
            } else {
                tmp[k] = nums[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            tmp[k] = nums[i];
            i++;
            k++;
        }

        while (j <= right) {
            tmp[k] = nums[j];
            j++;
            k++;
        }

        for (int p = left; p <= right; p++) {
            nums[p] = tmp[p];
        }
    }
}
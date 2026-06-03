class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            int sumA = nums1[a[0]] + nums2[a[1]];
            int sumB = nums1[b[0]] + nums2[b[1]];
            return Integer.compare(sumA, sumB);
        });

        int n = nums1.length;
        int m = nums2.length;

        for (int i = 0; i < Math.min(n, k); i++) {
            pq.offer(new int[]{i, 0});
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();

            int i = cur[0];
            int j = cur[1];

            result.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            if (j + 1 < m) {
                pq.offer(new int[]{i, j + 1});
            }
        }

        return result;
    }
}
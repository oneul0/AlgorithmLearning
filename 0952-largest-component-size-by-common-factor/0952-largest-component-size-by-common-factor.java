class Solution {
    static class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) return;

            if (size[rootA] < size[rootB]) {
                int temp = rootA;
                rootA = rootB;
                rootB = temp;
            }

            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }
    }

    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        DSU dsu = new DSU(n);

        // 소인수 -> 그 소인수를 처음 가진 nums의 인덱스
        Map<Integer, Integer> factorOwner = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int x = nums[i];

            for (int f = 2; f * f <= x; f++) {
                if (x % f == 0) {
                    connectByFactor(factorOwner, dsu, f, i);

                    while (x % f == 0) {
                        x /= f;
                    }
                }
            }

            if (x > 1) {
                connectByFactor(factorOwner, dsu, x, i);
            }
        }

        int[] count = new int[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int root = dsu.find(i);
            count[root]++;
            answer = Math.max(answer, count[root]);
        }

        return answer;
    }

    private void connectByFactor(Map<Integer, Integer> factorOwner, DSU dsu, int factor, int index) {
        if (!factorOwner.containsKey(factor)) {
            factorOwner.put(factor, index);
        } else {
            dsu.union(index, factorOwner.get(factor));
        }
    }

}
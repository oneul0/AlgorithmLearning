class Solution {
    public long countPalindromePaths(List<Integer> parent, String s) {
        //등장 횟수가 홀수인 문자가 0개 또는 1개여야 함
        //그래서 홀수만 센다

        int n = parent.size();
        List<int[]>[] gr = new ArrayList[n];
        for(int i = 0; i<n; i++){
            gr[i] = new ArrayList<>();
        }
        for(int i = 1; i<n; i++){
            int p = parent.get(i);
            int bit = 1 << (s.charAt(i) - 'a');
            gr[p].add(new int[]{i, bit});
        }

        Map<Integer, Integer> count = new HashMap<>();
        long answer = 0;

        Deque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0,0}); //node, mask

        while(!stack.isEmpty()){
            int[] cur = stack.pop();
            int node = cur[0];
            int mask = cur[1];

            answer += count.getOrDefault(mask, 0);

            for(int i = 0; i<26; i++){
                int target = mask ^ (1<<i);
                answer += count.getOrDefault(target, 0);
            }

            count.put(mask, count.getOrDefault(mask, 0) + 1);

            for(int[] next : gr[node]){
                int child = next[0];
                int bit = next[1];

                stack.push(new int[]{child, mask^bit});
            }
        }
        return answer;
    }
}
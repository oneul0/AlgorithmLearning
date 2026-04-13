import java.util.*;
class Solution {
    class Pair implements Comparable<Pair> {
        int size;
        int amount;
        Pair(int size, int amount){
            this.size = size;
            this.amount = amount;
        }
        @Override
        public int compareTo(Pair o){
            return o.amount - this.amount;
        }
    }
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder());

        int answer = 0;
        int sum = 0;

        for (int c : counts) {
            sum += c;
            answer++;
            if (sum >= k) break;
        }

        return answer;
    }
}
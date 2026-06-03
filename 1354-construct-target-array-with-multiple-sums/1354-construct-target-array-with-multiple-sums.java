import java.util.*;

class Solution {
    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;

        for (int num : target) {
            pq.offer(num);
            sum += num;
        }

        while (true) {
            int max = pq.poll();
            long rest = sum - max;

            if (max == 1) return true;

            if (rest == 1) return true;

            if (rest == 0 || max <= rest) return false;

            long prev = max % rest;

            if (prev == 0) return false;

            sum = rest + prev;
            pq.offer((int) prev);
        }
    }
}
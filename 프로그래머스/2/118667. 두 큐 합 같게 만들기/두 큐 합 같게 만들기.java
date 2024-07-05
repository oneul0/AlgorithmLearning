import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0, sum2 = 0;
        Queue<Integer> q1 = new ArrayDeque<>();
        for (int i = 0; i < queue1.length; i++) {
            q1.add(queue1[i]);
            sum1 += queue1[i];
        }

        Queue<Integer> q2 = new ArrayDeque<>();
        for (int i = 0; i < queue2.length; i++) {
            q2.add(queue2[i]);
            sum2 += queue2[i];
        }

        while (sum1 != sum2) {
            if(answer> queue1.length+queue2.length+1) return -1;
            if (sum1 > sum2) {
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.add(q1.remove());
            } else if (sum1 < sum2) {
                sum2 -= q2.peek();
                sum1 += q2.peek();
                q1.add(q2.remove());
            }
            answer++;
        }
        return answer;
    }
}
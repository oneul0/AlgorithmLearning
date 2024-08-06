import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> st = new ArrayDeque<>();
        for(int i = 0; i < prices.length; i++) {
            while(!st.isEmpty() && prices[st.peek()] > prices[i]) {
                int cur = st.pop();
                answer[cur] = i-cur;
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int cur = st.pop();
            answer[cur] = prices.length-cur-1;
        }



        return answer;
    }
}
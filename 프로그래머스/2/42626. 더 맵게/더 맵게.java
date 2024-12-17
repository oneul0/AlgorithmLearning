import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }
        int cnt = 0;
        while(pq.peek() < K && pq.size() > 1){
            int s1 = pq.remove();
            int s2 = pq.remove();
            pq.offer(s1+(s2*2));
            cnt++;
        }
        
        if(pq.size() == 1 && pq.peek()<K) return -1;
        
        return cnt;
    }
}
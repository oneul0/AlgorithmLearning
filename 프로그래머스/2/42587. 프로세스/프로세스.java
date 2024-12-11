import java.util.*;
class Solution {
    Queue<Pair> q = new ArrayDeque<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    public int solution(int[] priorities, int location) {
        int answer = 0;
        for(int i = 0; i<priorities.length; i++){
            q.offer(new Pair(i,priorities[i]));
            pq.offer(priorities[i]);
        }
        
        
        while(!pq.isEmpty()){
            Pair cur = q.remove();
            if(cur.priority == pq.peek()) {
                answer++;
                if(cur.idx == location) break;
                pq.remove();
            }
            else{
                q.offer(cur);    
            }
            
        }
        return answer;
    }
}

class Pair{
    int idx, priority;
    Pair(int idx, int priority){
        this.idx = idx;
        this.priority = priority;
    }
}
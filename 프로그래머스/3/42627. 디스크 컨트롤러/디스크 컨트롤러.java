import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, time = 0;

        // 소요시간 우선순위 큐
        PriorityQueue<int[]> workQ = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        // 작업 요청 시점 우선순위 큐
        PriorityQueue<int[]> waitQ = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        
        for(int[] j : jobs) waitQ.offer(j);

        // 소요시간 우선순위 큐 또는 작업 요청 시점 우선순위 큐가 비어있지 않을 때
        while(!waitQ.isEmpty() || !workQ.isEmpty()){
            // 현재 시간에 수행 가능한 작업
            while(!waitQ.isEmpty() && waitQ.peek()[0] <= time){
                workQ.offer(waitQ.poll());
            }

            if(workQ.isEmpty()){
                time = waitQ.peek()[0];
            }
            else{
                int[] j = workQ.poll();
                answer += time + j[1] - j[0];
                time += j[1];
            }
        }

        return answer / jobs.length;
    }
}
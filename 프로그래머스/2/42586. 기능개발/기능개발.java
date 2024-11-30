import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer;
        int max = 0, cnt = 1;
        Queue<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i = 0; i<progresses.length; i++){
            int left = 100-progresses[i];
            int dday = (left%speeds[i] == 0) ? left/speeds[i] : left/speeds[i]+1;
            q.offer(dday);
        }
        
        while(!q.isEmpty()){
            cnt = 1;
            max = q.remove();
            while(!q.isEmpty() && max >= q.peek()){
                q.remove();
                cnt++;
            }
            tmp.add(cnt);
        }
        answer = new int[tmp.size()];
        for(int i = 0; i<tmp.size(); i++){
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}
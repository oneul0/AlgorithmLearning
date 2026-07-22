import java.util.*;
class Solution {
    class Pair{
        int to, depth;
        Pair(int to, int depth){
            this.to = to;
            this.depth = depth;
        }
    }
    int answer = 0;
    public int solution(int n, int[][] edge) {
        List<List<Integer>> gr = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            gr.add(new ArrayList<>());
        }
        for(int[] e : edge){
            gr.get(e[0]).add(e[1]);
            gr.get(e[1]).add(e[0]);
        }
        int maxVal=0;
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(1, 0));
        int[] dist = new int[n+1];
        dist[1] = 1;
        while(!q.isEmpty()){
            Pair cur = q.poll();
            
            for(int next : gr.get(cur.to)){
                if(dist[next] == 0){
                    q.offer(new Pair(next, cur.depth+1));
                    dist[next] = cur.depth+1;
                    maxVal = Math.max(maxVal, cur.depth+1);
                }
            }
        }
        
        for(int i = 1; i<=n; i++){
            if(maxVal==dist[i]) answer++;
        }
        
        return answer;
    }
    
}
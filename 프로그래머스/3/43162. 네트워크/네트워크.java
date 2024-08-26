import java.util.*;
class Solution {
    ArrayList<ArrayList<Integer>> gr = new ArrayList<>();
    int n = 0;
    boolean[] chk;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.n = n;
        chk =  new boolean[n];
        for(int i = 0; i<computers.length; i++){
            gr.add(new ArrayList<>());
        }
        
        for(int i = 0; i<computers.length; i++){
            for(int j = 0; j<computers[i].length; j++){
                if(computers[i][j] == 1) {
                    gr.get(i).add(j);
                    gr.get(j).add(i);
                }
            }
        }
        
        for(int i = 0; i<n; i++){
            if(!chk[i]){
                bfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    void bfs(int sx){
        Queue<Integer> q = new ArrayDeque<>();
        
        q.add(sx);
        chk[sx] = true;
        
        while(!q.isEmpty()){
            int cx = q.remove();
            for(int nxt : gr.get(cx)){
                if(!chk[nxt]){
                    q.add(nxt);
                    chk[nxt] = true;
                }
            }
        }
        
    }
}
import java.util.*;
class Solution {
    ArrayList<ArrayList<Integer>> tree;
    int answer = 30000;
    public int solution(int n, int[][] wires) {
        tree =  new ArrayList<>(n+1);
        for(int i = 0; i<n+1; i++){
            tree.add(new ArrayList<>());
        }
        for(int[] wire : wires){
            tree.get(wire[0]).add(wire[1]);
            tree.get(wire[1]).add(wire[0]);
        }
        
        for(int[] wire : wires){
            int u = wire[0], v=wire[1];
            boolean[] visited = new boolean[n+1];
            visited[v] = true;
            int count = dfs(u,visited);
            answer = Math.min(answer, Math.abs(n-2*count));
        }
        
        return answer;
    }
    
    int dfs(int cur, boolean[] visited){
        visited[cur] = true;
        
        int count = 1;
        
        for(int nxt : tree.get(cur)){
            if(!visited[nxt]){
                count += dfs(nxt, visited);
            }
        }
        
        return count;
    }
}
import java.util.*;

class Solution {
    int[] info;
    int[][] edges;
    int max = 0;
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        this.edges = edges;
        
        dfs(0, 0, 0, new boolean[info.length]);
        
        return max;
    }
    
    void dfs(int cur, int sheep, int wolf, boolean[] chk) {
        chk[cur] = true;
        int cur_sheep = (sheep + (info[cur]^1));
        int cur_wolf = (wolf + info[cur]);
        max = Math.max(max, cur_sheep);
        if(cur_sheep <= cur_wolf) return;
        
        
        for(int[] edge : edges){
            if(chk[edge[0]] && !chk[edge[1]]){
                dfs(edge[1], cur_sheep, cur_wolf, chk.clone());
            }
        }
    }
}

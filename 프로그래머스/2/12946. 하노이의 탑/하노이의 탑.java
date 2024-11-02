import java.util.*;
class Solution {
    ArrayList<int[]> tmp = new ArrayList<>();
    int n;
    public int[][] solution(int n) {
        this.n = n;
        dfs(1, 2, 3, 0);
        int[][] answer = new int[tmp.size()][2];
        for(int i = 0; i<tmp.size(); i++){
            answer[i] = tmp.get(i);
        }
        return answer;
    }
    
    void dfs(int start, int by, int end, int depth){
        if(depth == n) return;
        
        dfs(start, end, by, depth+1);
        tmp.add(new int[]{start, end});
        dfs(by, start, end, depth+1);
    }
}
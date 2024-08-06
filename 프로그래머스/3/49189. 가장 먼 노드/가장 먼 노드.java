import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0, maxNum = 0;
        boolean[] visited = new boolean[n+1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] e : edge){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int[] tmp = new int[n+1];
        tmp[0] = -1;

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{1,0});
        visited[1] = true;

        while(!q.isEmpty()){
            int[] cur = q.remove();
            tmp[cur[0]] = cur[1];

            for(int nxt : adj.get(cur[0])){
                if(!visited[nxt]){
                    visited[nxt] = true;
                    q.add(new int[]{nxt,cur[1]+1});
                    maxNum = Math.max(maxNum,cur[1]+1);
                }
            }
        }

        for(int cnt : tmp){
            if(cnt == maxNum) answer++;
        }

        return answer;
    }
}
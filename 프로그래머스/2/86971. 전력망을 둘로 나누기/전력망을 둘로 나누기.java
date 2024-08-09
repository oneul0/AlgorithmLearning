import java.util.*;
class Solution {
    ArrayList<ArrayList<Integer>> tree;
    int answer = 30000;
    public int solution(int n, int[][] wires) {
        tree =  new ArrayList<>(n+1);
        for(int i = 0; i<n+1; i++){
            tree.add(new ArrayList<>());
        }
        // 1. 무방향 그래프로 바꾸기
        for(int[] wire : wires){
            tree.get(wire[0]).add(wire[1]);
            tree.get(wire[1]).add(wire[0]);
        }
        
        // 2. 탐색을 시작할 정점과 끊어낼 정점 정하기(어느 간선을 끊을지)
        for(int[] wire : wires){
            boolean[] visited = new boolean[n+1];
            //주어진 간선 정보는 이어질 수 있는 간선의 모든 경우의 수이므로
            //wires를 순회하는 것 만으로도 모든 경우의 수를 구할 수 있음
            //이어진 간선을 끊기 위해 v2를 구해 방문처리
            int v1 = wire[0], v2=wire[1];
            // 2.1 간선 끊기
            visited[v2] = true;
            
            //dfs가 더해준 count값 받기
            // 2.2 트리 하나의 정점 수 구하기
            int count = dfs(v1,visited);
            //짝수로 만들어서 나뉜 전력망 중 어느것으로 빼도 같은 값이 나오도록
            // 2.3 차이가 최소가 될 때의 개수 구하기
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
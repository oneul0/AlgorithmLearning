import java.util.*;
class Solution {
    int[] parents;
    public int solution(int n, int[][] costs) {
        int answer=0;
        parents = new int[n];
        
        for(int i = 0; i<n; i++){
            parents[i] = i;
        }
        
        Arrays.sort(costs, (a,b) -> Integer.compare(a[2], b[2]));
        
        int cnt = 0;
        for(int[] cost : costs){
            int a = cost[0];
            int b = cost[1];
            
            if(find(a) != find(b)){
                union(a,b);
                answer+=cost[2];
                cnt++;
                
                if(cnt == n-1) break;
            }
        }
        return answer;
    }
    
    void union(int x, int y){
        x = find(x);
        y = find(y);
        
        if(x == y) return;
        //x가 y의 부모이면
        if(x <= y) parents[y] = x;
        else parents[x] = y;
    }
    
    int find(int cur){
        if(parents[cur] == cur) return cur;
        return find(parents[cur]);
    }
}
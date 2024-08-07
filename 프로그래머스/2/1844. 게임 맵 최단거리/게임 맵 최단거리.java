import java.util.*;

class Solution {
    
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        Queue<int[]> q = new ArrayDeque<>();
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};        
        
        q.add(new int[]{0,0});
        while(!q.isEmpty()){
            int[] cur = q.remove();
            
            for(int i = 0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(nx>=0&&nx<maps.length&&ny>=0&&ny<maps[0].length&&maps[nx][ny] == 1){
                    q.add(new int[]{nx,ny});
                    maps[nx][ny] += maps[cur[0]][cur[1]];
                }
            }   
        }
        if(maps[maps.length-1][maps[0].length-1] == 1) return -1;
        return maps[maps.length-1][maps[0].length-1];
    }
}
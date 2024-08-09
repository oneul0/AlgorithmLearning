import java.util.*;
class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    int n,m;
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        this.n = places.length;
        this.m = places[0].length;
        for(int i = 0; i<places.length; i++){
            answer[i] = isValid(places[i]);
        }
        
        return answer;
    }
    
    
    int isValid(String[] room){
    //P찾기    
        for(int i= 0; i<room.length; i++){
            for(int j = 0; j<room[0].length(); j++){
                if(room[i].charAt(j) == 'P')
                    if(!bfs(i,j,room)) return 0;
            }
        }
        return 1;
        
    }
    
    //유효성검증
    boolean bfs(int sx, int sy, String[] room){
        Queue<int[]> q= new ArrayDeque<>();
        boolean[][] chk = new boolean[n][m];
        q.offer(new int[]{sx,sy,0});
        chk[sx][sy] = true;
        while(!q.isEmpty()){
            int[] cur = q.remove();
            
            for(int i =0; i<4; i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];
                if(cur[2] >= 2 || nx<0||ny<0||nx>=n||ny>=m||chk[nx][ny]||room[nx].charAt(ny) == 'X') continue;
                if(room[nx].charAt(ny) == 'P') return false;
                q.offer(new int[]{nx,ny,cur[2]+1});
                chk[nx][ny] = true;
            }
        }
        return true;
    }
}
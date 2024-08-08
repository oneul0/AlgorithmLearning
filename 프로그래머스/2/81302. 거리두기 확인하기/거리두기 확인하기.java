import java.util.*;
class Solution {
    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for(int i = 0; i<places.length; i++){
            answer[i] = init(places[i]);
        }
        return answer;
    }
    
    int init(String[] place){
        //P 찾기
        for(int i = 0; i<place.length; i++){
            for(int j = 0; j<place[i].length(); j++){
                if(place[i].charAt(j) == 'P'){
                    if(!bfs(i,j,place)) return 0;
                }
            }
        }
        return 1;
    }
    
    boolean bfs(int sx, int sy,String[] place){
        boolean[][] room = new boolean[place.length][place[0].length()];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sx,sy,0});
        room[sx][sy] = true;
        while(!q.isEmpty()){
            int[] cur = q.remove();
            
            for(int d= 0;d<4;d++){
                int nx = cur[0]+dx[d];
                int ny = cur[1]+dy[d];
                if(cur[2]+1 <= 2 && nx>=0 && nx<place.length && ny>=0 && ny < place[0].length() && !room[nx][ny] && place[nx].charAt(ny) != 'X'){
                    if(place[nx].charAt(ny) == 'P') return false;
                    
                    q.add(new int[]{nx,ny,cur[2]+1});
                    room[nx][ny] = true;     
                }
                

            }
        }
        
        return true;
    }
}
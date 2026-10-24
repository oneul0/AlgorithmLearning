import java.util.*;
class Solution {
    int n, m;
    char[][] arr;
    int[] dx=  {-1,1,0,0}, dy = {0,0,-1,1};
    public int solution(String[] storage, String[] requests) {
        this.n = storage.length;
        this.m = storage[0].length();
        arr = new char[n+2][m+2];
        for(int i = 0; i<n+2; i++){
            Arrays.fill(arr[i], ' ');
        }
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                arr[i][j] = storage[i-1].charAt(j-1);
            }
        }
        int answer = n*m;
        for(String req : requests){
            char target = req.charAt(0);
            if(req.length() == 1){
                answer -= forklit(target);
            }
            else{
                answer -= crain(target);
            }
        }
        
        return answer;
    }
    public int forklit(char target){
        int count = 0;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n+2][m+2];
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int d = 0; d<4; d++){
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                
                if(nx<0 || ny<0 || nx>=n+2 || ny>=m+2) continue;
                
                if(visited[nx][ny]) continue;
                
                if(arr[nx][ny] == ' '){
                    q.offer(new int[]{nx, ny});
                }
                else if(arr[nx][ny] == target){
                    arr[nx][ny] = ' ';
                    count++;
                }
                visited[nx][ny] = true;
            }
        }
        return count;
    }
    public int crain(char target){
        int count = 0;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=m; j++){
                if(arr[i][j] == target){
                    arr[i][j] = ' ';
                    count++;
                }
            }
        }
        return count;
    }
}
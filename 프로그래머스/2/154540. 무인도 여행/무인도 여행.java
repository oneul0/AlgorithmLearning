import java.util.*;
class Solution {
    int n,m;
    char[][] map;
    boolean[][] visited;
    int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][];
        for(int i = 0; i<n; i++){
            map[i] = maps[i].toCharArray();
        }
        visited = new boolean[n][m];
        List<Integer> results = new ArrayList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] == 'X' || visited[i][j]) continue;
                int result = getArea(i,j);
                if(result > 0) {
                    results.add(result);
                }
            }
        }
        Collections.sort(results);
        return results.isEmpty() ? new int[]{-1} : results.stream().mapToInt(Integer::intValue).toArray();
    }
    public int getArea(int sx, int sy){
        int area = map[sx][sy]-'0';
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i = 0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                
                if(nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny]) continue;
                if(map[nx][ny] == 'X') continue;
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                area += map[nx][ny] - '0';
            }
        }
        
        return area;
    }
}
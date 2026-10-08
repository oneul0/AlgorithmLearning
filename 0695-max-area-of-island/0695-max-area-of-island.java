class Solution {
    int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    int n, m;
    boolean[][] visited;
    int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        n = grid.length;
        m = grid[0].length;
        visited= new boolean[n][m];
        int answer = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    answer = Math.max(answer, bfs(i, j));
                }
            }
        }
        return answer;
    }
    public int bfs(int sx, int sy){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        int result = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            for(int i = 0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0 || ny<0 || nx>=n || ny>=m || visited[nx][ny]) continue;
                if(grid[nx][ny] == 0) continue;
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
                result++;
            }
        }
        return result;
    }
}
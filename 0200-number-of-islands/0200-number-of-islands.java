class Solution {
    public int numIslands(char[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        boolean[][] visited = new boolean[N][M];
        int answer = 0;
        for(int i = 0; i<N; i++){
            for(int j = 0; j<M; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    answer++;
                    bfs(i, j, N, M, grid, visited);
                }
            }
        }
        return answer;
    }

    public int[] dx = {-1,1,0,0}, dy = {0,0,-1,1};
    public void bfs(int sx, int sy, int N, int M, char[][] grid, boolean[][] visited){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sx, sy});
        visited[sx][sy] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0 ||ny<0 || nx>=N || ny>=M || visited[nx][ny] || grid[nx][ny] == '0') continue;
                q.offer(new int[]{nx, ny});
                visited[nx][ny] = true;
            }
        }
    }
}
class Solution {
    int row, col;
    int perimeter = 0;
    int[][] arr;
    boolean[][] visited;

    int[] dx = {-1,1,0,0};
    int[] dy = {0,0,-1,1};
    public int islandPerimeter(int[][] grid) {
        row = grid.length+2;
        col = grid[0].length+2;

        arr = new int[row][col];
        visited = new boolean[row][col];

        for(int i=1; i<row-1; i++) {
            for(int j=1; j<col-1; j++) {
                arr[i][j] = grid[i-1][j-1];
            }
        }

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(arr[i][j]==0 && !visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        return perimeter;
    }

    private void dfs(int cx, int cy) {
        visited[cx][cy] = true;

        for(int i=0; i<4; i++) {
            int nx = cx + dx[i];
            int ny = cy + dy[i];

            if (nx<0 || ny<0 || nx>=row || ny>=col) continue;

            if (arr[nx][ny] == 1) {
                perimeter++;
                continue;
            }

            if (!visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
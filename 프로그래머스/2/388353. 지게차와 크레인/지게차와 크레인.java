import java.util.*;

class Solution {
    int n, m;
    int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    char[][] storages;
    
    public int solution(String[] storage, String[] requests) {
        init(storage);
        
        for (String request : requests) {
            char target = request.charAt(0);
            
            if (request.length() == 1) {
                // 외부에서 접근 가능한 컨테이너만 제거
                removeAccessibleContainers(target);
            } else {
                // 모든 해당 컨테이너 제거
                removeAllContainers(target);
            }
        }
        
        // 남은 컨테이너 개수 계산
        return countRemainingContainers();
    }
    
    // 모든 해당 종류 컨테이너 제거
    public void removeAllContainers(char container) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (storages[i][j] == container) {
                    storages[i][j] = '.';
                }
            }
        }
    }
    
    // 외부에서 접근 가능한 컨테이너만 제거(bfs)
    public void removeAccessibleContainers(char container) {
        boolean[][] visited = new boolean[n + 2][m + 2];
        Deque<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                
                if (nx < 0 || ny < 0 || nx >= n + 2 || ny >= m + 2) continue;
                if (visited[nx][ny]) continue;
                
                visited[nx][ny] = true;
                char cell = storages[nx][ny];
                
                if (cell == '.') {
                    q.offer(new int[]{nx, ny});
                }
                
                if (cell == container) {
                    storages[nx][ny] = '.';
                    cell = '.';
                }
            }
        }
    }
    
    // 남은 컨테이너 개수 세기
    public int countRemainingContainers() {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (storages[i][j] != '.') {
                    count++;
                }
            }
        }
        return count;
    }
    
    public void init(String[] storage) {
        n = storage.length;
        m = storage[0].length();
        storages = new char[n + 2][m + 2];
        
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(storages[i], '.');
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                storages[i + 1][j + 1] = storage[i].charAt(j);
            }
        }
    }
}
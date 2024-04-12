#include <iostream>
#include <vector>
using namespace std;

int dr[4] = { -1, 0, 1, 0 };
int dc[4] = { 0, 1, 0, -1 };

int N, M;
int r, c, d; 
int ans = 0;
vector<vector<int>> arr;
vector<vector<bool>> visited;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N >> M;
	cin >> r >> c >> d;
    arr.resize(N,vector<int>(M,0));
    visited.resize(N, vector<bool>(M, false));
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> arr[i][j];
		}
	}

	while (true)
	{
        // 현재 칸이 아직 청소 되지 않은 경우 
		// 청소를 안 했다면 청소 시키기
		if (visited[r][c] == false) {
			ans++;
			visited[r][c] = true; 
		}
		
		// 아직 청소 안 함
		bool isClean = false;

		for (int i = 1; i <= 4; i++) {
            // 현재 방향에서 i만큼 회전
			int nd = (4 + d - i) % 4;
			int nr = r + dr[nd];
			int nc = c + dc[nd];

			// 청소를 이미 했거나 벽이면 처음으로
			if (visited[nr][nc] || arr[nr][nc]) {
				continue;
			}

			// 청소 했음을 표시 
			isClean = true;

			// 좌표 갱신
			r = nr;
			c = nc;
			d = nd; 
			break;

		}

		// 청소를 안 했다면 (청소를 할 곳이 없다면)
		if (isClean == false) {
			int nr = r + dr[(d + 2) % 4];
			int nc = c + dc[(d + 2) % 4];

			// 후진 시 벽이면 종료
			if (arr[nr][nc]==1) {
				break;
			}
			// 벽이 아니면 후진 
			else {
				r = nr;
				c = nc; 
			}
		}

	}

	cout << ans; 


	return 0;
}

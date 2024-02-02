#include <iostream>
#include <queue>
#include <algorithm>
#include <vector>
using namespace std;

const int MAX_N = 26;

int n;
int map[MAX_N][MAX_N];
bool visited[MAX_N][MAX_N];

vector<int> complex_sizes;  // 각 복합체의 크기를 저장하는 벡터
int complex_count = 0;      // 복합체의 개수
int dx[] = {-1, 0, 1, 0};
int dy[] = {0, 1, 0, -1};

void bfs(int sx, int sy) {
    queue<pair<int, int>> q;
    q.push(make_pair(sx, sy));
    visited[sx][sy] = true;
    int current_complex_size = 1;  // 현재 복합체 크기

    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        if (x == n - 1 && y == n - 1) {
            complex_sizes.push_back(current_complex_size);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] && !visited[nx][ny]) {
                visited[nx][ny] = true;
                current_complex_size++;
                q.push(make_pair(nx, ny));
            }
        }
    }
    complex_count++;
}

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            char c;
            cin >> c;
            map[i][j] = c - '0';
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (map[i][j] && !visited[i][j]) {
                bfs(i, j);
            }
        }
    }

    cout << complex_count << "\n";
    sort(complex_sizes.begin(), complex_sizes.end());
    for (int i = 0; i < complex_sizes.size(); i++) {
        cout << complex_sizes[i] << '\n';
    }

    return 0;
}

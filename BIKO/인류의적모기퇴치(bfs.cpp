#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N, M;
vector<vector<int>> v;
vector<pair<int,int>> dCross = {{-1,0}, {1,0}, {0,-1}, {0,1}};
vector<pair<int,int>> dx = {{-1,-1}, {1,1}, {-1,1}, {1,-1}};

bool isValid(int nx, int ny, vector<vector<bool>>& chk){
    return nx >= 0 && ny >= 0 && nx < N && ny < N && !chk[nx][ny];
}

int xKill(int sx, int sy, vector<vector<bool>>& chk){
    int kill = 0;
    queue<pair<pair<int,int>,int>> q; // 좌표와 현재 깊이 정보를 함께 저장
    
    q.push({{sx,sy}, 0}); // 시작 좌표와 초기 깊이 0을 큐에 삽입
    chk[sx][sy] = true;

    while (!q.empty()){
        int cx = q.front().first.first;
        int cy = q.front().first.second;
        int depth = q.front().second;
        q.pop();
        
        kill += v[cx][cy];
        
        for (int d = 0; d < 4; d++){
            int nx = cx + dx[d].first;
            int ny = cy + dx[d].second;
            if (isValid(nx, ny, chk)){
                if(depth+1<=M){
                    q.push({{nx, ny}, depth + 1}); // 다음 위치와 깊이 정보 삽입
                    chk[nx][ny] = true;
                }
                
            }
        }
    }
    
    return kill;
}

int crossKill(int sx, int sy, vector<vector<bool>>& chk){
    int kill = 0;
    queue<pair<pair<int,int>,int>> q;
    
    q.push({{sx,sy}, 0});
    chk[sx][sy] = true;

    while (!q.empty()){
        int cx = q.front().first.first;
        int cy = q.front().first.second;
        int depth = q.front().second;
        q.pop();
        
        kill += v[cx][cy];

        for (int d = 0; d < 4; d++){
            int nx = cx + dCross[d].first;
            int ny = cy + dCross[d].second;
            if (isValid(nx, ny, chk)){
                if(depth+1<=M){
                    q.push({{nx, ny}, depth + 1}); // 다음 위치와 깊이 정보 삽입
                    chk[nx][ny] = true;
                }
            }
        }
    }
    
    return kill;
}

void findLoc(){
    int maxKill = 0;
    for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
            vector<vector<bool>> chk(N, vector<bool>(N, false));
            maxKill = max(maxKill, max(xKill(i, j, chk), crossKill(i, j, chk)));
        }
    }
    cout << maxKill;
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M;
    v.resize(N, vector<int>(N,0));

    for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
            cin >> v[i][j];
        }
    }
    findLoc();

    return 0;
}

//인접행렬 설명 : https://sarah950716.tistory.com/12

#include <iostream>
#include <string>
#include <vector>
#include <queue>
#include <cstring>

using namespace std;

int N,M;
string s;
vector<vector<int>> maze;
bool chk[101][101];

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

void bfs(int sx, int sy);

int main(){
    cin >> N >> M;
    maze.resize(N);
    for(int i = 0; i<N; i++){
        cin >> s;
        for(char c : s) maze[i].push_back(c-'0');
    }
    //memset(chk, false, sizeof(chk));
    bfs(0,0);

    cout << maze[N-1][M-1];
    return 0;
}

void bfs(int sx, int sy){
    queue<pair<int,int>> q;
    
    q.push(make_pair(sx,sy));
    chk[sx][sy] = true;

    while(!q.empty()){
        int nx = q.front().first;
        int ny = q.front().second;
        q.pop();

        for(int i = 0; i<4; i++){
            int nxt_x = nx+dx[i];
            int nxt_y = ny+dy[i];
            if(nxt_x>=0 && nxt_y>=0 && nxt_x<N && nxt_y<M && !chk[nxt_x][nxt_y] && maze[nxt_x][nxt_y]){
                q.push(make_pair(nxt_x, nxt_y));
                chk[nxt_x][nxt_y] = true;
                maze[nxt_x][nxt_y] += maze[nx][ny];
                //cout << "maze[nx][ny] : "<< maze[nx][ny] << " maze[nxt_x][nxt_y] : "<< maze[nxt_x][nxt_y] << endl;
            }
        }

    }
}
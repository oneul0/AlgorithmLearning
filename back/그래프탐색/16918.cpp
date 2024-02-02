//https://www.acmicpc.net/problem/16918

#include <iostream>
#include <vector>
#include <string>
#include <queue>

using namespace std;

int R, C, N;
string s;
vector<vector<char>> grid;
vector<vector<int>> chk;
queue<pair<int,int>> last; //마지막 홀수번째 폭탄 위치의 벡터



//방향 벡터
int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

void bfs(int sx, int sy){
    queue<pair<int,int>> q;
    q.push(make_pair(sx,sy));
    chk[sx][sy] = 1;
    if(grid[sx][sy] == 'O') last.push(make_pair(sx,sy));

    while(!q.empty()){
        int cx = q.front().first;
        int cy = q.front().second;
        q.pop();

        for(int i = 0; i<4; i++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            if(nx >= 0 && ny >= 0 && nx < R && ny < C && !chk[nx][ny] && grid[nx][ny] == 'O'){
                q.push(make_pair(nx, ny));
                chk[nx][ny] = 1;
                last.push(make_pair(nx,ny));
            }
        }
        
    }
    
}

void bomber(vector<vector<char>>& grid, queue<pair<int,int>>& last){
    while(!last.empty()){
        int x = last.front().first;
        int y = last.front().second;
        last.pop();
        grid[x][y] = '.';

        for(int i = 0; i<4; i++){
            int ax = x+dx[i];
            int ay = y+dy[i];
            if(ax >= 0 && ay >= 0 && ax < R && ay < C && grid[ax][ay] == 'O'){
                grid[ax][ay] = '.';
            }
        }
    }
    
}

void exe_bfs(){
    for(int j = 0; j<R; j++){
        for(int k = 0; k<C; k++){
            bfs(j,k);
        }
    }
}

int main(){
    cin >> R >> C >> N;
    grid.resize(R);
    chk.resize(R, vector<int>(C, 0));
    for(int i = 0; i<R; i++){
        cin >> s;
        for(char c : s) grid[i].push_back(c);
    }

    exe_bfs();

    for(int i = 2; i<=N; i++){
        fill(chk.begin(), chk.end(), vector<int>(C, 0));

        if(i%2 == 0){
            fill(grid.begin(), grid.end(), vector<char>(C, 'O'));
        }
        if(i%2 == 1){
            bomber(grid, last);
            exe_bfs();
        }
    }
    
    for(int i = 0; i<R; i++){
        for(int j = 0; j<C; j++){
            cout << grid[i][j];
        }
        cout << '\n';
    }

    return 0;
}


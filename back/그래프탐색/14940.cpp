#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int n, m;
vector<vector<int>> map;
vector<vector<bool>> chk;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

void bfs(int sx, int sy){
    queue<pair<int,int>> q;
    q.push(make_pair(sx,sy));
    chk[sx][sy] = true;
    map[sx][sy] = 0;

    while(!q.empty()){
        int cx = q.front().first;
        int cy = q.front().second;
        q.pop();
        
        for(int i = 0; i<4; i++){
            int nx = cx + dx[i];
            int ny = cy + dy[i];
            if(nx>=0 && ny>=0 && nx<n && ny<m && !chk[nx][ny] && map[nx][ny] == -1){
                map[nx][ny] = 1;
                q.push(make_pair(nx,ny));
                chk[nx][ny] = true;
                map[nx][ny] += map[cx][cy];
            }
        }
        
    }
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    int sx, sy;
    cin >> n >> m;
    map.resize(n, vector<int>(m,0));
    chk.resize(n, vector<bool>(m,false));

    for(int i = 0; i<n; i++){
        for(int j = 0; j<m; j++){
            cin >> map[i][j];
            if(map[i][j] == 2){
                sx = i;
                sy = j;
            }
            //2랑 0은 0
            //1만 -1
            map[i][j] = map[i][j] == 2 || map[i][j] == 0 ? 0 : -1;
        }
    }

    bfs(sx,sy);

    for(int i = 0; i<n; i++){
        for(int j = 0; j<m; j++){
            cout << map[i][j] <<" ";
        }
        cout << '\n';
    }





    return 0;
}
#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int n,m;
vector<vector<char>> map;
bool chk[11][11][11][11];
int dx[] = {1,-1,0,0}, dy[] = {0,0,1,-1};

struct coords{
    int rx,ry, bx,by, cnt;
};

void go(int& rx, int& ry, int& distance, int& idx){
    while(map[rx+dx[idx]][ry+dy[idx]] != '#' && map[rx][ry] != 'O'){
        rx += dx[idx];
        ry += dy[idx];
        distance+=1;
    }
}

void bfs(int rx, int ry, int bx, int by){
    queue<coords> q;
    q.push({rx,ry,bx,by,0});
    chk[rx][ry][bx][by] = true;
    while(!q.empty()){
        int crx = q.front().rx, cry = q.front().ry, cbx = q.front().bx, cby = q.front().by, ccnt = q.front().cnt;
        q.pop();

        if(ccnt >= 10) break;
        for(int i = 0; i<4; i++){
            int nrx = crx, nry = cry, nbx = cbx, nby = cby;
            int rc = 0, bc = 0, ncnt = ccnt+1;

            go(nrx, nry, rc, i);
            go(nbx, nby, bc, i);

            if(map[nbx][nby] == 'O') continue;
            if(map[nrx][nry] == 'O'){
                cout << ncnt;
                return;
            }
            if(nrx == nbx && nry == nby){
                if(rc>bc) nrx -= dx[i], nry -=dy[i];
                else nbx -= dx[i], nby -= dy[i];
            }
            if(chk[nrx][nry][nbx][nby]) continue;
            chk[nrx][nry][nbx][nby] = true;
            q.push({nrx,nry, nbx, nby, ncnt});
        }
    }
    cout << -1;

}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    
    int rx,ry,bx,by;
    cin >> n >> m;
    map.resize(n);
    for(int i = 0; i<n; i++){
        string s;
        cin >> s;
        for(int j = 0; j<m; j++){
            map[i].push_back(s[j]);
            if(s[j] == 'R'){
                rx = i; ry = j;
                map[i][j] = '.';
            }
            else if(s[j] == 'B'){
                bx = i; by = j;
                map[i][j] = '.';
            }
        }
    }

    bfs(rx, ry, bx, by);

    return 0;
}
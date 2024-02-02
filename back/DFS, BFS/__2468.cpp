#include <iostream>
#include <vector>
#include<queue>
#include<algorithm>

using namespace std;
const int MAXINT = 10001;
int n;
vector<vector<int>> map;
vector<int> area;
int drownHt, cht, sx, sy, area_cnt = 0;
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};
queue<pair<int,int>> q;

void bfs(int sx, int sy, bool visited[][MAXINT]){
    
    //q.push(make_pair(sx,sy));
    //visited[sx][sy] = true;


    while (!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        for(int i = 0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny] && map[nx][ny]>cht){
                visited[nx][ny] = true;
                q.push(make_pair(nx,ny));
            }
        }
    }
    area_cnt++;
}

int main(){
    cin >> n;
    map.resize(n, vector<int>(n));
    

    for(int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
            int each;
            cin >> each;
            map[i][j] = each;
            
            if(each>drownHt){
                drownHt = each;
            }
        }
    }
    area.resize(drownHt, 0);
    for(int k = 0; k<drownHt; k++){
        cht = k;
        bool visited[MAXINT][MAXINT] = {false};
        area_cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(!visited[i][j]&&map[i][j]>cht){
                    visited[i][j] = true;
                    q.push(make_pair(i,j));
                }
            }
        }
        bfs(sx,sy, visited);
    }
    
    sort(area.begin(), area.end(), [](int a, int b){return a>b;});
    
    cout << area[0];

    return 0;
}
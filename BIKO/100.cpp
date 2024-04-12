#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int n, m;
vector<vector<int>> village;
int crossdx[] = {0, 0, -1, 1};
int crossdy[] = {-1, 1, 0, 0};
int xdx[] = {1,1,-1,-1};
int xdy[] = {1,-1,1,-1};

int bfs(int sx, int sy, bool ver){
    int killNum = 0;
    //좌표 방문 여부
    vector<vector<bool>> visited(n, vector<bool>(n,false));
    queue<pair<int,int>> q;
    q.push({sx,sy});
    village[sx][sy] = true;
    int cnt = 0;

    int cx = q.front().first;
    int cy = q.front().second;
    visited[cx][cy] = true;
    q.pop();
    killNum+=village[cx][cy];
    //뻗어나갈 방향 정하기
    for(int i = 0; i<4; i++){
            int nx=-1, ny=-1;
            if(ver){
                nx = cx+crossdx[i];
                ny = cy+crossdy[i];
            }
            else{
                nx = cx+xdx[i];
                ny = cy+xdy[i];
            }
            if(nx>=0 && nx<n && ny>=0 && ny<n && !visited[nx][ny]){
                q.push({nx,ny});
            }
    }
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        //num에 추가
        killNum+= village[x][y];
        
        //

    }
    

    for(int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
            if(!visited[i][j]) cout << 0<<" ";
            else cout << 1 << " ";
        }
        cout << endl;
    }


    return killNum;
}

int main() {
    cin >> n >> m;
    village.resize(n);
    for(int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
            int num;
            cin >> num;
            village[i].push_back(num);
        }
    }
    vector<int> ans;
    bool ver = true;
    for(int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
            ans.push_back(bfs(i,j,ver));
        }
    }
    
    ver = false;

    for(int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
            ans.push_back(bfs(i,j,ver));
        }
    }
    int answer = *max_element(ans.begin(), ans.end());
    cout << answer;
    return 0;
}
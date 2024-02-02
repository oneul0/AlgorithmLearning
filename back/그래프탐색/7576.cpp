//https://www.acmicpc.net/problem/7576

#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

int N, M, days = 0;

vector<vector<int>> box;
vector<vector<bool>> chk;
queue<pair<int,int>> q;
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

void bfs(){
    while(!q.empty()){
        cout <<"q size : "<<q.size()<<endl;
        days++;
        int cx = q.front().first;
        int cy = q.front().second;
        q.pop();
        for(int i = 0; i<4; i++){
            int nx = cx+dx[i];
            int ny = cy+dy[i];
            if(nx>=0 && ny >= 0 && nx<N && ny<M && !chk[nx][ny] && box[nx][ny] == 0){
                q.push(make_pair(nx,ny));
                chk[nx][ny] = true;
                box[nx][ny] = 1;
            }
        }
    }
    days++;
}

int main(){
    cin >> N >> M;
    box.resize(N, vector<int>(M, 0));
    chk.resize(N, vector<bool>(M, false));
    for(int i = 0; i<N; i++){
        for(int j = 0; j<M; j++){
            cin >> box[i][j];
            if(box[i][j] == 1){
                q.push(make_pair(i,j));
                chk[i][j] = true;
            }
        }
    }
    bfs();
    
    for(int i = 0; i<N; i++){
        if(find(box[i].begin(), box[i].end(), 0)!=box[i].end())
            days = -1;
    }
    cout << days;
    return 0;
}
#include<iostream>
#include<queue>
#include<algorithm>
using namespace std;

const int MAX_N = 26;

int n;
int map[MAX_N][MAX_N];
bool visited[MAX_N][MAX_N];

vector<int> complex;
int complex_num = 0;
int cnt;
int dx[] = {-1, 1, 0, 0 };
int dy[] = { 0, 0, -1, 1};

int bfs(int sx, int sy){
    
    queue<pair<int,int>> q;
    q.push(make_pair(sx,sy));
    visited[sx][sy] = true;
    complex.push_back(1);
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        


        for(int i = 0; i<4; i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx >= 0 && nx < n && ny >= 0 && ny < n && map[nx][ny] && !visited[nx][ny]){
                visited[nx][ny] = true;
                complex[complex_num]++;
                
                q.push(make_pair(nx,ny));
            }
          
        }
    }
    complex_num++;
    
    return -1;
}

int main(){
    cin >> n;

    for(int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
            char c;
            cin >> c;
            map[i][j] = c-'0';
        }
    }

    for(int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
            if(map[i][j] && !visited[i][j]){
                bfs(i,j);
                
            }
        }
    }

    int complex_cnt = complex.size();

    cout<< complex_cnt << "\n";
    sort(complex.begin(), complex.end());
    for(int i = 0; i< complex.size(); i++){
        cout << complex[i] << '\n';
    }

    return 0;
}
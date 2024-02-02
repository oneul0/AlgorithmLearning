#include<iostream>
#include<queue>
#include<vector>

using namespace std;

int m, n, h;
int dx[] = {-1, 1, 0, 0, 0, 0};
int dy[] = {0, 0, -1, 1, 0, 0};
int dz[] = {0, 0, 0, 0, -1, 1};
vector<vector<vector<int>>> box;
bool visited[101][101][101];
queue<pair<pair<int,int>,int>> q;
int day = 0;

void bfs(){
    
    while(!q.empty()){
        
        int qsize = q.size();
        for(int j = 0; j<qsize; j++){
            int x = q.front().first.first;
            int y = q.front().first.second;
            int z = q.front().second;

            q.pop();

            for(int i = 0; i< 6; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                int nz = z+dz[i];
        
                if(nx >= 0 && nx<m && ny >= 0 && ny<n && nz>=0 && nz<h && !box[nz][ny][nx] && !visited[nz][ny][nx]){
                    visited[nz][ny][nx] = true;
                    box[nz][ny][nx] = 1;
                
                    q.push(make_pair(make_pair(nx,ny), nz));

                }
                
            }
        
        
        }
        day++;
            
    }
    day--;
}


int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    bool unrito = false;
    int unriped = 0;
    cin >> m >> n>> h;

    for(int i = 0; i<h; i++){
        vector<vector<int>> mat;
        for(int j = 0; j<n; j++){
            vector<int> row;
            for(int k = 0; k<m; k++){
                int tomato;
                cin>> tomato;
                row.push_back(tomato);
                if(tomato == 1){
                    q.push(make_pair(make_pair(k, j),i));
                    visited[i][j][k] = true;
                    
                }
                else if(tomato == 0){
                    unriped++;
                }
            }
            mat.push_back(row);
        }
        box.push_back(mat);
    }
    
    if(!unriped && !q.empty()){
        cout<< 0;
        return 0;
    }

    bfs();

    

    for(int i = 0; i<h; i++){
        for(int j = 0; j<n; j++){
            for(int k = 0; k<m; k++){
                if(box[i][j][k] == 0){
                    unrito = true;
                    break;
                }
            }
        }
    }
    if(unrito){
        cout<<-1;
    }
    else{
        cout << day;
    }
    
    return 0;
}
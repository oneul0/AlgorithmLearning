#include <iostream>
#include <vector>
#include <stack>

using namespace std;

struct Coords
{
    int x,y,idx,depth;
};

int N, M;
vector<vector<int>> v;
vector<pair<int,int>> dc = {{-1,0}, {1,0}, {0,-1}, {0,1}};
vector<pair<int,int>> dx = {{-1,-1}, {1,1}, {-1,1}, {1,-1}};

bool isValid(int nx, int ny, vector<vector<bool>>& chk, int depth){
    return nx >= 0 && ny >= 0 && nx < N && ny < N && !chk[nx][ny] && depth<M;
}


int xKill(int sx,int sy){
    vector<vector<bool>> chk(N, vector<bool>(N, false));
    int kill = 0;
    stack<Coords> st;
    kill += v[sx][sy];
    chk[sx][sy]= true;

    for(int i = 0; i<4; i++){
        st.push({sx,sy,i,0});

        while(!st.empty()){
            Coords c = st.top();
            int nx = c.x+dx[c.idx].first;
            int ny = c.y+dx[c.idx].second;
            st.pop();
            if(isValid(nx,ny,chk,c.depth)){
                st.push({nx,ny,c.idx,c.depth+1});
                chk[nx][ny]= true;
                kill += v[nx][ny];
            }
        }
    }
    return kill;
}

int crossKill(int sx,int sy){
    vector<vector<bool>> chk(N, vector<bool>(N, false));
    int kill = 0;
    stack<Coords> st;
    kill += v[sx][sy];
    chk[sx][sy]= true;
    
    for(int i = 0; i<4; i++){
        st.push({sx,sy,i,0});
        while(!st.empty()){
            Coords c = st.top();
            int nx = c.x+dc[c.idx].first;
            int ny = c.y+dc[c.idx].second;
            st.pop();
            if(isValid(nx,ny,chk,c.depth)){
                st.push({nx,ny,c.idx,c.depth+1});
                chk[nx][ny]= true;
                kill += v[nx][ny];
            }
        }
        
    }
    return kill;
}


void findLoc(){
    int maxKill = 0;
    for (int i = 0; i < N; i++){
        for (int j = 0; j < N; j++){
            
            maxKill = max(maxKill, max(xKill(i, j), crossKill(i, j)));
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
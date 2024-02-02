#include <iostream>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

int N;
string s;
vector<vector<int>> apt;
bool chk[26][26];
vector<int> complex;

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};
int apts;

int dfs(int sx, int sy){
    
    chk[sx][sy] = true;
    apts++;

    for(int i = 0 ; i<4; i++){
        int nx = sx+dx[i];
        int ny = sy+dy[i];
        if(nx >= 0 && ny >= 0 && nx<N && ny<N && !chk[nx][ny] && apt[nx][ny]){
            dfs(nx,ny);
        }
    }

    return apts;
}

int main(){
    cin >> N;
    apt.resize(N);
    for(int i = 0; i<N; i++){
        cin >> s;
        for(char c : s) apt[i].push_back(c-'0');
    }

    for(int i = 0; i<N; i++){
        for(int j = 0; j<N; j++){
            if(!chk[i][j] && apt[i][j]){
                apts = 0;
                complex.push_back(dfs(i,j));
            }
        }
    }
    
    int comp_size = complex.size();
    cout << comp_size << "\n";
    sort(complex.begin(), complex.end());
    for(auto& a : complex)
        cout << a<<"\n";


    return 0;
}
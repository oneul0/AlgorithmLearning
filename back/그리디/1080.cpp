#include<iostream>
#include<vector>
#include<algorithm>
#include<string>

using namespace std;

void conv(int x, int y, vector<vector<vector<int>>> mat){
    for(int i = 0; i<3; i++){
        for(int j = 0; j<3; j++){
            mat[0][i][j] = ~mat[0][i][j];
        }
    }
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int n,m;
    cin >> n >> m;
   
    vector<vector<vector<int>>> mat(2, vector<vector<int>>(n));
    
    for(int i = 0; i<2; i++){
        for(int j = 0; j<n; j++){
            string each;
            cin >> each;
            for(char c : each){
                int ci = c-'0';
                mat[i][j].push_back(ci);
            }
        }
    }
    if(n <3 || m<3){ cout << -1; return 0;}
    
    int cnt = 0;
    for(int i = 0; i<=n-2; i++){
        for(int j = 0; j<=m-2; j++){
            if(mat[0][i][j] != mat[1][i][j]){ cnt++; conv(i,j, mat); }
        }
    }

    cout << cnt;
    return 0;
}
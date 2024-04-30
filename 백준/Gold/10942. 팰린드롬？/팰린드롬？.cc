//https://4z7l.github.io/2021/04/07/algorithms-boj-10942.html
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int n, m;
int num, s, e;

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    cin >> n;
    vector<int> v(n+1,0);
    vector<vector<bool>> pal(n+1, vector<bool>(n+1,false));
    //입력
    for(int i = 1; i<=n; i++){
        cin >> v[i];
    }

    //길이가 2고 같은 수인 모든 쌍
    for(int i = 1; i<=n-1; i++){
        if(v[i] == v[i+1]) pal[i][i+1] = true;
    }
    for(int i = 1; i<=n; i++) pal[i][i] = true;

    for(int i = n-1; i>=1; i--){
        for(int j = i+1; j<=n; j++){
            if(v[i] == v[j] && pal[i+1][j-1] == true){
                pal[i][j] = true;
            }
        }
    }
    int m, e, s;
    cin >> m;
    for(int i = 0; i<m; i++){
        cin >> s>>e;
        cout << pal[s][e] << '\n';
    }
    return 0;
}
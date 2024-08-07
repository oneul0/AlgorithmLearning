#include <bits/stdc++.h>
//백트래킹 : 특정 루트로 회귀하여 다른 갈래를 탐색하는 알고리즘
using namespace std;

int n,m;
int seq[9] = {0};
bool visited[9] = {0};
vector<int> v;
void dfs(int idx){
    if(idx == m){
        for(int i = 0; i<m; i++){
            cout << seq[i] << " ";   
        }
        cout << "\n";
        return;
    }
    for(int i = 0; i<n; i++){
        if(!visited[i]){
            visited[i] = true;
            seq[idx] = v[i];
            dfs(idx+1);
            visited[i] = false;
        }
    }

}

int main(){
    ios_base::sync_with_stdio(0);
    cin >> n >>m;
    v.resize(n);
    for(int i = 0; i<n; i++)
        cin >> v[i];
    sort(v.begin(), v.end());
    dfs(0);

    return 0;
}
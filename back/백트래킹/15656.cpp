#include <bits/stdc++.h>
using namespace std;

int n,m;
int seq[9] = {0};
bool visited[9] = {0};
vector<int> v;
void dfs(int num, int idx){
    
    if(idx == m){
        for(int i = 0; i<m; i++){
            cout << seq[i] << " ";   
        }
        cout << "\n";
        return;
    }
    for(int i = num; i<n; i++){
        visited[i] = false;
        if(!visited[i]){
            visited[i] = true;
            seq[idx] = v[i];
            dfs(i+1,idx+1);
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
    dfs(0, 0);

    return 0;
}
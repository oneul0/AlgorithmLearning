#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n,last_node = 0;
vector<vector<int>> v;
vector<int> path;
vector<int> visited;
void dfs(int s){
    path[s] = last_node;
    visited[s] = 1;
    //cout << s<<" ";
    
    //sort(v[s].begin(), v[s].end());
    for(int i = 0; i<v[s].size(); i++){
        int nxt = v[s][i];
        if(!visited[nxt]){
            last_node = s;
            dfs(nxt);
        }
    }
}


int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n;
    v.resize(n+1);
    path.resize(n+1, 0);
    visited.resize(n+1,0);
    v[0].push_back(0);
    for(int i = 1; i<n; i++){
        int n1,n2;
        cin >> n1 >> n2;
        v[n1].push_back(n2);
        v[n2].push_back(n1);
    }

    dfs(1);


    for(int i =2; i<=n; i++){
        cout << path[i] << "\n";
    }

    return 0;
}
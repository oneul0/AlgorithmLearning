#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

vector<vector<int>> g;
int n,m,v;
vector<int> visited;
void dfs(int v){
    visited[v] = 1;
    cout << v << " ";
    sort(g[v].begin(), g[v].end());
    for(int i = 0; i<g[v].size(); i++){
        int nxt = g[v][i];
        if(!visited[nxt]) dfs(nxt);
    }
}

void bfs(int v){
    queue<int> q;
    visited[v] = 1;
    q.push(v);
    sort(g[v].begin(), g[v].end());
    while(!q.empty()){
        int c = q.front();
        q.pop();
        cout << c << " ";
        for(int i = 0; i<g[c].size(); i++){
            int nxt = g[c][i];
            if(!visited[nxt]){
                q.push(nxt);
                visited[nxt] = 1;
            }
        }
    }
}

int main(){
    cin >> n >> m >> v;
    g.resize(n+1);
    visited.resize(n+1,0);
    for(int i = 0; i<m; i++){
        int node1, node2;
        cin >> node1 >> node2;
        g[node1].push_back(node2);
        g[node2].push_back(node1);
    }
    dfs(v);
    cout << "\n";
    visited.clear();
    visited.resize(n+1,0);
    bfs(v);
    return 0;
}
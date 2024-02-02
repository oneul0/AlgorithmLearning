#include <iostream>
#include <queue>
#include <vector>
#include <cstring>

using namespace std;


void dfs(vector<vector<int>>& graph, int x, vector<bool>& visited){
    visited[x] = true;
    cout << x << " ";
    for(int ne : graph[x]){
        if(!visited[ne]) dfs(graph, ne, visited);
    }
}

void bfs(vector<vector<int>>& graph, int x, vector<bool>& visited){
    queue<int> q;
    q.push(x);
    visited[x] = true;
    
    while(!q.empty()){
        int s = q.front();
        q.pop();
        cout << s << " ";
        for(int ne : graph[s]){
            if(!visited[ne]){
                q.push(ne);
                visited[ne] = true;
            }
        }
        
    }
}

int main(void){
    int n, m, v;
    
    cin >> n >> m >> v;
    
    vector<bool> visited(n+1, false);
    
    vector<vector<int>> graph(n+1);
    
    for(int i = 0; i<m; ++i){
        int node, line;
        cin >> node >> line;
        graph[node].push_back(line);
        graph[line].push_back(node);
    }
    
    dfs(graph, v, visited);
    fill(visited.begin(), visited.end(), false);
    cout << endl;
    bfs(graph, v, visited);
    
    return 0;
}
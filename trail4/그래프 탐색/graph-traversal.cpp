#include <iostream>
#include <vector>

using namespace std;

int n, m, answer= 0;
vector<vector<int>> gr;
vector<bool> visited;

void dfs(int cur, int depth){
    for(int next : gr[cur]){
        if(!visited[next]){
            visited[next] = true;
            answer++;
            dfs(next, depth+1);
        }
    }
}

int main() {
    cin >> n >> m;
    gr.resize(n+1);
    visited.resize(n+1, false);
    for (int i = 0; i < m; i++) {
        int from, to;
        cin >> from >> to;
        gr[from].push_back(to);
        gr[to].push_back(from);
    }
    visited[1] = true;
    dfs(1, 0);
    cout << answer;
    return 0;
}

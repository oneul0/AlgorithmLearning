#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

void dfs(int x, vector<vector<int>>& map, vector<int>& check, vector<int>& visits, bool& is_same, vector<int>& visited) {
    if (check[x]) return;

    visited.push_back(x);
    check[x] = true;

    for (const int& y : map[x]) {
        if (!check[y]) 
            dfs(y, map, check, visits, is_same, visited);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;
    bool is_same = true;

    vector<int> check(N + 1, 0);
    vector<vector<int>> map(N + 1);
    vector<int> visits;
    vector<int> visited;

    for (int i = 0; i < N - 1; i++) {
        int node1, node2;
        cin >> node1 >> node2;
        map[node1].push_back(node2);
        map[node2].push_back(node1);
    }

    cin.ignore();

    string line;
    getline(cin, line);
    stringstream ss(line);

    int num;
    while (ss >> num) {
        visits.push_back(num);
    }

    dfs(1, map, check, visits, is_same, visited);

    if (visited.size() != visits.size()) {
        is_same = false;
    } else {
        for (int d = 0; d < visited.size(); d++) {
            if (visited[d] != visits[d]) {
                is_same = false;
                break;
            }
        }
    }

    if (is_same) 
        cout << 1;
    else 
        cout << 0;

    return 0;
}

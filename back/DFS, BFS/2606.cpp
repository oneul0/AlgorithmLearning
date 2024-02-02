#include<iostream>
#include<vector>

using namespace std;

int n,m;

int result = 0;

void dfs(int pos, vector<vector<int>>& v, bool* check){
    check[pos] = true;
    
    for(auto& x : v[pos]){
        if(!check[x]){ result++; dfs(x, v, check); }
    }
    
}

int main(){
    cin >> n;
    cin >> m;
    vector<vector<int>> v(n+1);
    bool check[n+1] = {false};
    for(int i = 0; i<m; i++){
        int node1, node2;
        cin >> node1 >> node2;
        v[node1].push_back(node2);
        v[node2].push_back(node1);
    }
    dfs(1, v, check);
    cout << result;

    return 0;
}
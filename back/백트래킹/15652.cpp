#include <iostream>
#include <vector>

using namespace std;

int n,m;
int seq[9] = {0};
bool visited[9] = {0};

void dfs(int num, int idx){
    visited[idx] = false;
    if(idx == m){
        for(int i = 0; i<m; i++)
            cout << seq[i] << ' ';
        cout << '\n';
        return;
    }
    
    for(int i = num; i<=n; i++){
        visited[i] = false;
        if(!visited[i]){
            visited[i] = true;
            seq[idx] = i;
            dfs(i, idx+1);
            
        }
    }
}

int main(){
    ios_base::sync_with_stdio(0);
    cin >> n >>m;
    dfs(1,0);
    return 0;
}
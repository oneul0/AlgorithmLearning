#include <iostream>
#include <vector>

using namespace std;

int n,m;
int seq[9] = {0};
bool visited[9] = {0};

void dfs(int num, int idx){
    if(idx == m){
        for(int i = 0; i<m; i++)
            cout << seq[i] << ' ';
        cout << '\n';
        return;
    }
    
    for(int i = num; i<=n; i++){
        if(!visited[i]){
            visited[i] = true;
            seq[idx] = i;
            dfs(i+1, idx+1);
            visited[i] = false;
        }
    }
}

int main(){
    cin >> n >>m;
    dfs(1,0);
    return 0;
}
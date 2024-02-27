#include <iostream>
#include <vector>

using namespace std;

int n,m;
int seq[9] = {0};
bool visited[9] = {0};

void dfs(int idx){
    cout << "seq : "<<<<" ";
    if(idx == m){
        for(int i = 0; i<m; i++)
            cout << seq[i] << ' ';
        cout << '\n';
        return;
    }
    
    for(int i = 1; i<=n; i++){
        
        if(!visited[i]){
            visited[i] = true;
            seq[idx] = i;
            dfs(idx+1);
            visited[i] = false;
        }
        
    }
}

int main(){
    cin >> n >>m;
    dfs(0);
    return 0;
}
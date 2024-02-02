#include<iostream>
#include<vector>

using namespace std;
vector<int> a[1001];
bool visited[1001];

vector<int> v;
void dfs(int si){
    visited[si] = true;
    for(int i = 0; i<a[si].size(); i++){
        int dx = a[si][i];
        if(!visited[dx]){dfs(dx);}
    }
    
}

int main(){
    
    int t;
    cin >>t;
    for(int i = 0; i<t; i++){
        int n;
        cin >> n;
        for(int j = 1; j<=n; j++){
            a[j].clear();
            visited[j] = false;
        }
        for(int j = 1; j<=n; j++){
            int c;
            cin >> c;
            a[j].push_back(c);

        }
        int cnt = 0;
        for(int j=1; j<=n; j++){
            if(!visited[j]){
                dfs(j);
                cnt++;
            }
        }
        v.push_back(cnt);
        
    }

    for(auto& f : v){
        cout<<f<<'\n';
    }
    return 0;
}
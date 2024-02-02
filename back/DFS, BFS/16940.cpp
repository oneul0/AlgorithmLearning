#include <iostream>
#include <vector>
#include <queue>
#include<algorithm>

using namespace std;

bool chk[100001];
int n, a, b;
int order[100001];
vector<int> v[100001];
vector<int> bfs_order;

void bfs(int pos){
    queue<int> q;
    q.push(pos);
    chk[pos] = true;

    while(!q.empty()){
        int x = q.front();
        q.pop();
        bfs_order.push_back(x);
        for(int i = 0; i<v[x].size(); i++){
            int y = v[x][i];
            if(!chk[y]){
                q.push(y);
                chk[y] = true;
            }
        }
    }
}

bool comp(int& a, int& b){
    return order[a] < order[b];
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    
    cin >> n;

    for(int i = 0; i<n-1; i++){
        cin >> a >> b;
        v[a].push_back(b);
        v[b].push_back(a);
    }

    vector<int> tmp(n+1);
    for(int i = 1; i<=n; i++){
        cin >> tmp[i];
        order[tmp[i]] = i;
    }

    for(int i = 1; i<=n; i++){
        sort(v[i].begin(), v[i].end(), comp);
    }

    bfs_order.push_back(0);
    if(tmp[1] == 1) bfs(1);
    if(bfs_order == tmp) cout << 1;
    else cout << 0;

    return 0;
}
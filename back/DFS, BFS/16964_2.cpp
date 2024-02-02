#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

const int MAX = 100001;
int n, a, b;
vector<int> v[MAX];
bool ch[MAX];
int order[MAX];
vector<int> dfs_order;

void dfs(int pos) {
    if(ch[pos]) return;
    ch[pos] = true;
    dfs_order.push_back(pos);
    for(auto i : v[pos]){
        if(!ch[i]) dfs(i);
    }
}

bool comp(int& a, int& b){
    return order[a] <order[b];
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n;

   for(int i = 0; i<n-1; i++){
    cin >> a >> b;
    v[a].push_back(b);
    v[b].push_back(a);
   }
   vector<int> temp(n+1);
   for(int i = 1; i<=n; i++){
    cin >>temp[i];
    order[temp[i]] = i;
   }

    for(int i = 1; i<= n; i++){
        sort(v[i].begin(), v[i].end(), comp);
    }

    dfs_order.push_back(0);
    if(temp[1] == 1) dfs(1);
    if(dfs_order == temp) cout << "1";
    else cout << "0";


    return 0;
}
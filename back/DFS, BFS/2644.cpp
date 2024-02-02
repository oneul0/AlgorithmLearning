#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
const int MAX_chon = 101;
int n, a,b, m;
int whatchon = 0;
int chon = 0;
vector<vector<int>> chons(MAX_chon);
bool check[MAX_chon];

void dfs(int start, int target, int whatchon){
    check[start] = true;
    cout << "start : " << start << "chon : " << whatchon << "\n";
    if(start == target){ chon = whatchon; }

    for(int ch : chons[start]){
        if(!check[ch]){  dfs(ch, target, whatchon+1); }
    }
    
}

int main(){

    cin >> n;
    cin >> a >> b;
    cin >> m;
    for(int i = 0; i<m; i++){
        int x,y;
        cin >> x >> y;
        chons[x].push_back(y);
        chons[y].push_back(x);
    }

    dfs(a,b, whatchon);

    if(chon == 0){
        cout << -1;
    }
    else{
        cout << chon;
    }
    return 0;
}
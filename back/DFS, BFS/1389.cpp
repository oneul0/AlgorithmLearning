#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int n,m;
vector<vector<int>> r;
vector<int> cnts;

int cunt;
void bfs(int sx, bool check[]){
    queue<int> q;
    q.push(sx);
    check[sx] = true;
    
    while(!q.empty()){
        int x = q.front();
        q.pop();
        
        for(int& dx : r[x]){
            if(!check[dx]){
                q.push(dx);
                check[dx] = true;
                cunt++;
            }
        }
    }
    if(cunt >0){
        cunt--;
    }
    cnts.push_back(cunt);
    cunt = 0;
}

int main(){
    cin >>n >>m;

    r.resize(n+1);
    for(int i = 1; i<=m; i++){
        int k,j;
        cin >> k >> j;
        r.at(k).push_back(j);
        r.at(j).push_back(k);
    }
    
    for(int i = 1; i<=m; i++){
        bool check[5001] = {false};
        bfs(i, check);

    }
    
    int max = *max_element(cnts.begin(), cnts.end());
    cout << max;
    return 0;
}
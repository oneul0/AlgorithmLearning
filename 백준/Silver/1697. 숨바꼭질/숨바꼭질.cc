#include<iostream>
#include<vector>
#include<queue>

using namespace std;
const int MAXN = 100001;
int n, k;
bool visited[MAXN];


void bfs(int n){
    queue<pair<int, int>> q;

    q.push(make_pair(n, 0));
    visited[n] = true;
    
    while(!q.empty()){
        int x = q.front().first;
        int cnt = q.front().second;
        q.pop();
        if(x == k){cout << cnt; break; }

        for(int step : {x-1, x+1, 2*x}){
            if(step>=0 && step<MAXN){
                if(!visited[step]){
                    visited[step] = true;
                    q.push(make_pair(step, cnt+1));
                }
            }
        }
    }
    
}

int main(){
    
    cin >> n >> k;
    
    bfs(n);

    return 0;
}
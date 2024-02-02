#include<iostream>
#include<queue>
#include<vector>

using namespace std;

const int MAX_F = 1000001;
int f,s,g,u,d;
vector<bool> visited(MAX_F, false);
int stair = 1;
void bfs(int n){
    queue<pair<int,int>> q;
    q.push(make_pair(n,0));
    visited[n] = true;

    while(!q.empty()){
        int x = q.front().first;
        int cnt = q.front().second;
        if(x == g){
            cout << cnt;
            return;
        }
        cnt++;
        q.pop();

        for(int next : {x+u,x-d}){
            if(next >= 1 && next <= f && !visited[next]){
                visited[next] = true;
                q.push(make_pair(next, cnt));
            }
        }
    }

    cout << "use the stairs";
}


int main(){
    cin >> f >> s >> g >> u >> d;
    bfs(s);
    return 0;
}
#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <set>

using namespace std;

int n, m;
vector<vector<int>> v;
vector<pair<int,int>> path_length;
vector<int> chk;
vector<int> is_root;

void bfs(int sx){
    int path_leng = -1;
    queue<int> q;
    chk[sx] = 1;
    q.push(sx);

    while(!q.empty()){
        int nx = q.front();
        q.pop();
        path_leng++;
        for(int i = 0; i<v[nx].size(); i++){
            int ny = v[nx][i];
            if(!chk[ny]){
                chk[ny] = 1;
                q.push(ny);
            }
        }
    }
    //cout << "패스 랭뜨 : "<< path_leng<< " ";
    path_length.push_back(make_pair(sx, path_leng));
}
    
bool compare(const pair<int,int> &a, const pair<int, int> &b){
    if(a.second == b.second){
        return a.first < b.first;
    }
    return a.second > b.second;
}
//1~n이므로 입력을 받을 때 n1에 입력되는 것을 지우면 된다.
void dfs(int sx){
    int path_leng = -1;
    chk[sx] = 1;
    for(int i = 0; i<v[sx].size(); i++){
        int nx = v[sx][i];
        if(!chk[nx]){
            dfs(nx);
            path_leng++;
        }
    }
    cout<< "sx : "<< sx << " leng : "<<path_leng<<" ";
    path_length.push_back(make_pair(sx, path_leng));
}

int main(){
    int n1,n2;
    cin >> n >> m;
    
    v.resize(n+1);
    chk.resize(n+1,0);

    v[0].push_back(0);

    for(int i = 0; i<=n; i++) is_root.push_back(i);
    for(int i = 0; i<m; i++){
        cin >> n1 >> n2;
        if(find(is_root.begin(), is_root.end(), n1) - is_root.begin())
            is_root[find(is_root.begin(), is_root.end(), n1) - is_root.begin()] = 0;
        
        v[n2].push_back(n1); //신뢰받는 노드(n2)에서 접근할 수 있도록
    }

    for(int i = 1; i<=n; i++){
        //cout<<"i : "<<i<<" is_root : "<<is_root[i]<<endl;
        if(is_root[i] == 0) continue;
        bfs(i);
        fill(chk.begin(), chk.end(), 0);
    }
    sort(path_length.begin(), path_length.end(), compare);

    for(int i = 0; i<path_length.size(); i++){
        if(path_length[i].second == 0) break;
        cout << path_length[i].first << " ";
    }
   
    return 0;
}
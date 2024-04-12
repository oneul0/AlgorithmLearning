#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;
vector<vector<char>> map;
queue<int> sticks;
int R,C,N, t;
int direct[3][2] = {{1,0}, {0,-1}, {0,1}};

void fall(queue<pair<int,int>> fallBlocks){
    while(!fallBlocks.empty()){
        pair<int,int> cur = fallBlocks.front();
        map[cur.first][cur.second] = '.';
        fallBlocks.pop();
        
        for(int h = cur.first; h<=R; h++){
            if(map[h][cur.second] == 'x' || h==0){
                map[h-1][cur.second] = 'x';
                break;
            }
        }
    }
}

queue<pair<int,int>> bfs(pair<int,int> hit){
    queue<pair<int,int>> q; vector<vector<bool>> visited(R+1, vector<bool>(C,false)); queue<pair<int,int>> fallBlocks;
    q.push({hit.first, hit.second});

    while(!q.empty()){
        int h = q.front().first; int w = q.front().second;
        visited[hit.first][hit.second] = true;
        q.pop();
        for(int d = 0; d<3; d++){
            int nh = h+direct[d][0];
            int nw = w+direct[d][1];
            if(nh>=1&&nh<=R&&nw>=0&&nw<C&&!visited[nh][nw]&&map[nh][nw]=='x'){
                q.push({nh,nw});
                fallBlocks.push({nh,nw});
                visited[nh][nw] = true;
            }
        }

    }
    return fallBlocks;
}

bool isFall(const pair<int,int>& hit){
    bool chk = true;
    if(hit.second == 0) chk = (map[hit.first][hit.second+1] == 'x' ? false:true);
    else if(hit.second == C-1) chk = (map[hit.first][hit.second-1] == 'x' ? false:true);
    else {
        chk = ((map[hit.first][hit.second+1] == 'x' || map[hit.first][hit.second-1] == 'x') ? false:true);
    }
    return chk;
}

void throw_sticks(int height, bool isChang){
    pair<int,int> hit = {0,0};
    if(isChang){
        for(int i = 0; i<C; i++){
            if(map[height][i] == 'x'){
                hit.first = height; hit.second = i;
                break;
            }
        }
    }
    else{
        for(int i = C-1; i>=0; i--){
            if(map[height][i] == 'x'){
                hit.first = height; hit.second = i;
                break;
            }
        }
    }
    if(hit.first && isFall(hit)){ //hit이 갱신되고 양 옆에 미네랄이 없을 경우
        map[hit.first][hit.second] = '.';
        fall(bfs(hit)); //함께 떨어질 미네랄 리스트 갱신
    }
}

int main(){
    cin >> R >> C;
    map.resize(R+1);
    map[0].push_back('.');
    for(int i = 1; i<=R; i++){
        string s;
        cin >> s;
        for(char& c : s){
            map[i].push_back(c);
        }
    } 

    cin >>N;
    for(int i = 0; i<N; i++){
        cin >> t;
        sticks.push(t);
    }
    bool isChang=true;
    while(!sticks.empty()){
        throw_sticks(sticks.front(),isChang);
        sticks.pop();
        isChang = !isChang;
    }
    for(int i = 1; i<=R; i++){
        for(int j = 0; j<C; j++){
            cout << map[i][j];
        }
        cout << '\n';
    }

    return 0;
}
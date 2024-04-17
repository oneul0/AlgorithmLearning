#include <iostream>
#include <vector>
#include <queue>
using namespace std;

const int INF = 987654321;
//방향 전환 시 거울++
//다익스트라로 풀어보기

int w,h;
int direct[4][2] = {{0,1}, {0,-1}, {1,0}, {-1,0}};
vector<vector<char>> map;
vector<vector<int>> visited;
queue<pair<int,int>> sq;

struct coord
{
    int x;
    int y;
    int prev_direction;
    int mirrorNum;
    bool operator<(const coord& other) const {
        return mirrorNum > other.mirrorNum;
    }

};

bool isPromise(int dx, int dy){
    return (dx>=0 && dx<w && dy >= 0 && dy < h);
}

void dijikstra(queue<pair<int,int>>& sq){
    priority_queue<coord> pq;
    int sx = sq.front().first;
    int sy = sq.front().second;
    sq.pop();
    visited[sx][sy] = 0;
    coord crd = {sx,sy,-1,0};
    pq.push(crd);

    while(!pq.empty()){
        coord curCoord = pq.top();
        pq.pop();

        for(int i = 0; i<4; i++){
            int dx = curCoord.x+direct[i][0];
            int dy = curCoord.y+direct[i][1];
            int mirror = curCoord.mirrorNum;
            if(!isPromise(dx,dy)) continue;
            if(map[dy][dx] == '*') continue;
            if(curCoord.prev_direction != i){ mirror += 1; }
            if(visited[dx][dy] >= mirror){
                visited[dx][dy] = mirror;
                pq.push(coord{dx, dy, i, mirror});
            }
        }
    }
    cout << visited[sq.front().first][sq.front().second];
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr); cout.tie(nullptr);
    cin >> w >> h;
    map.resize(h); visited.resize(h,vector<int>(w,INF));
    for(int i = 0; i<h; i++){
        string s;
        cin >> s;
        for(int j = 0; j<w; j++){
            map[i].push_back(s[j]);
            if(s[j] == 'C') sq.push({i,j});
        }
    }
    dijikstra(sq);
    return 0;
}
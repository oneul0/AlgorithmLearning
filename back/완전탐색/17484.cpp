#include <iostream>
#include <vector>
#include <algorithm>
#include <ctime>
#include <climits>

using namespace std;

vector<vector<int>> map; //전체 맵
const unsigned int MAX_i = 10000000;
int dis[3] ={-1,0,1};

int n,m;

int travel(int cx, int cy, int direction_idx){

    if(cx == n){ return 0; }

    int fuel = MAX_i;
    for(int i = 0; i<3; i++){
        if(direction_idx == i) continue;
        int dx = cx+1;
        int dy = cy+dis[i];
        if(dx>n || dy < 0 || dy>m) continue;
        fuel = min(fuel, travel(dx, dy, i)+map[cx][cy]);
    }

    return fuel;
}


int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n >>m;

    map.resize(n, vector<int>(m,0));
    for(int i = 0; i<n; i++){
        for(int j = 0; j<m; j++){
            cin >> map[i][j];
        }
    }

    int answer = MAX_i;
    for(int i = 0; i<m; i++)
        answer = min(answer, travel(0, i, -1));

    cout << answer;
    return 0;
}
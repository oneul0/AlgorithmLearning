#include <iostream>
#include <queue>
#include <algorithm>
#include <limits>
using namespace std;

const int INF = INT32_MAX;
struct coord
{
    int distance;
    int hx,wy;
};
struct Cmp
{
    bool operator()(const coord& s1, const coord& s2) const{
        if(s1.distance == s2.distance) return s1.hx<s2.hx;
        else if(s1.hx==s2.hx) return s1.wy<s2.wy;
        return s1.distance < s2.distance; //오름차순
    }
};


bool isEdge(string s, int si, int j, int h){
    return (s[si]=='.' || s[si]=='#' || s[si]=='$') && ((j==0||j==h-1) || (si==0||si==s.length()-1));
}

void dijkstra(vector<vector<char>> prison, queue<pair<int,int>> startPoints, int h, int w){
    priority_queue<coord, vector<int>, Cmp> pq;
    vector<vector<int>> dists;
    
}

void input(int h, int w){
    vector<vector<char>> prison(h);
    queue<pair<int,int>> startPoints;
    for(int j = 0; j<h; j++){
        string s;
        cin >> s;
        for(int si = 0; si < w; si++){
            prison[si].push_back(s[si]);
            if(isEdge(s,si,j,h)){
                startPoints.push({j,si});
            }
        }
    }
    dijkstra(prison, startPoints, h, w);
}

int main(){
    int T;
    cin >> T;
    for(int i = 0; i<T; i++){
        int w,h;
        cin >> w >> h;
        input(h,w);
    }
    return 0;
}
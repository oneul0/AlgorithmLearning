#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <cmath>
#include <limits>

using namespace std;




void pathFind(const vector<vector<char>>& prison, queue<pair<int,int>> startPoints){

}

void inputs(int h, int w){
    vector<vector<char>> prison(h);
    queue<pair<int,int>> startPoints;
    priority_queue<int, vector<int>, greater<int>> ans;
    for(int i = 0; i<h; i++){
        string s;
        cin >> s;
        for(int j = 0; j<s.length(); j++){
            prison[i].push_back(s[j]);
            if((i == 0 || i==h-1 || j==0 || j ==s.length()-1) && (s[j] == '#' || s[j] == '.' || s[j] =='$')){
                startPoints.push({i,j}); //h w 순서
            }
        }
    }//input done
    pathFind(prison, startPoints);
}

int main(){
    int t, h, w;
    cin >> t;
    for(int i = 0; i<t; i++){
        cin >> h >> w;

    }
    return 0;
}
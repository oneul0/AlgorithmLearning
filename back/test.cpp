//#include <bits/stdc++.h>
#include <iostream>

using namespace std;

struct Chracter{
    pair<int,int> pos;
    int demage;
};
int n,hp,d, ans = 0;
int map[10][10]={};

void attack(int x, int y, int demage){
    //횡
    for(int i = 0; i<10; i++){
        if(map[x][i]!=-1 && map[x][i]!=0 && map[x][i] <=demage) ans++;
    }    

    //열
    for(int i = 0; i<10; i++){
        if(map[i][y]!=-1 && map[i][y]!=0 && map[i][y] <=demage) ans++;
    }   
}
int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    Chracter jenny;

    cin >> d; 
    jenny.demage = d;
    for(int i = 0; i<10; i++){
        for(int j = 0; j<10; j++){
            cin >> map[i][j];
            if(map[i][j] == -1)
                jenny.pos = {i,j};
        }
    }
    attack(jenny.pos.first, jenny.pos.second, jenny.demage);
    cout << ans;

    return 0;
}
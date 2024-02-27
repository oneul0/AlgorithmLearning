//#include<bits/stdc++.h>
#include<iostream>

using namespace std;
//백트래킹
//
int n, ans;
//대각선의 개수 2n-1
bool Y[20], DL[40], DR[40];

void dfs(int y, int cnt){
    if(cnt == n){
        ans++; 
        return;
    }
    for(int j=0;j<n;j++){
        if(Y[j] || DL[y + j] || DR[y - j + n])continue;
        Y[j] = DL[y + j] = DR[y - j + n] = true;
        dfs(y + 1, cnt + 1);
        Y[j] = DL[y + j] = DR[y - j + n] = false;
    }
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);

    cin >> n;    
    dfs(0, 0);
    cout << ans;

    return 0;
}
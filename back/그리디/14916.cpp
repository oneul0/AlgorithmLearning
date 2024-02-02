#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;
//Bottom-Up 방식 DP
int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int n;
    cin >> n;
    vector<int> v(n+1, -1);
    v[2] = 1;
    v[5] = 1;
    for(int i = 3; i<n+1; i++){
        if(v[i-2] != -1){ v[i] = v[i-2] +1; }
        if(v[i-5] != -1 && i>5){ v[i] = min(v[i], v[i-5] +1); }
    }

    cout << v[n];
    return 0;
}
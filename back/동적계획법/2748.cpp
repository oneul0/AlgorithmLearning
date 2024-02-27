#include <bits/stdc++.h>

using namespace std;
int n;
int main(){
    cin >> n;
    vector<long long> v(n+1,0);
    v[1] = v[2] = 1;
    if(n == 0||n==1||n==2){
        cout << v[n];
        return 0;
    }
    for(int i = 3; i<=n; i++){
        v[i] = v[i-1] + v[i-2];
    }
    cout << v[n];

    return 0;
}
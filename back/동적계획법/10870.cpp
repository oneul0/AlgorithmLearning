#include<bits/stdc++.h>

using namespace std;
int n, ans;
vector<int> v;

int main(){
    cin >> n;
    v.resize(n+1,0);
    v[0] = 0;
    v[1] = v[2] = 1;
    if(n == 0 ||n==1||n==2){
        cout << v[n];
        return 0;
    }
    for(int i = 3; i<=n; i++){
        v[i] = v[i-1]+v[i-2];
    }
    
    cout << v[n];
    return 0;
}
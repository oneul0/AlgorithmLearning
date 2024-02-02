#include <iostream>
#include <vector>

using namespace std;

vector<int> v;
int cnt = 0;
int w(int n){
    v[0] = 1;
    v[1] = 2;

    for(int i = 2; i<=n; i++){
        v[n] = (v[n-2]+v[n-1]) % 15746;
    }
    return v[n];
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int n;
    
    cin >>n;
    v.resize(n+1,0);
    for(int i =0; i<=n; i++){
        w(i);
    }
    cout << w(n-1);
    return 0;
}
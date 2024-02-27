#include <bits/stdc++.h>

using namespace std;

int t,n,m;
//nCm 조합찾기

int nCr(int n, int r){
    long long result = 1;
    for(int i = 1; i<=r; i++)
        result = result*(n-i+1)/i;

    return result;
}

int main(){
    cin >> t;
    for(int i = 0; i<t; i++){
        cin >> n >> m;
        cout << nCr(m, n)<<'\n';
    }
    return 0;
}
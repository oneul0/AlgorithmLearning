#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
vector<long> p;

int test(int n){
    if(n<3){ return p[n];}
    for(int i = 3; i<=n; i++){
        p[i] = p[i-2]+p[i-3];
    }
    return p[n];
}
int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int t, n;
    cin >> t;
    vector<int> v;
    while(t--){
        int c;
        cin >> c;
        v.push_back(c);
    }

    int maxn = *max_element(v.begin(), v.end());
    p.resize(maxn,0);
    p[0] = 1;
    p[1] = 1;
    p[2] = 1;
    test(maxn);
    for(auto& n : v){
        cout << p[n-1] << '\n';
    }
    return 0;
}
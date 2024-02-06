#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int n, a;
    cin >> n;
    vector<int> v;
    while(n--){
        cin >> a;
        v.push_back(a);
    }
    sort(v.begin(), v.end());
    for(auto& c : v) cout << c << '\n';
    return 0;
}
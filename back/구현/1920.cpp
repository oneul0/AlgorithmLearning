#include <iostream>
#include <algorithm>
#include <set>

using namespace std;

int m, a , find_e, ans;
//vector<int> v;
set<int> v;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> m;
    
    for(int i = 0; i<m; i++){
        cin >> a;
        v.insert(a);
    }
    cin >> m;
    for(int i = 0; i<m; i++){
        cin >> find_e;
        if(v.find(find_e) != v.end()) ans = 1;
        else ans =0;
        cout << ans <<'\n';
    }
    return 0;
}
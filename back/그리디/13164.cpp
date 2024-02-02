#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int n,k;
    cin >> n>> k;
    vector<int> tall;
    vector<int> subTall;

    for(int i =0; i<n; i++){
        int t;
        cin >> t;
        tall.push_back(t);    
    }

    for(int i = 0; i<n-1; i++){
        subTall.push_back(tall[i+1]-tall[i]);
    }
    sort(subTall.begin(), subTall.end());
    int ans = 0;
    for(int i = 0; i<n-k; i++){
        ans += subTall[i];
    }
    cout << ans;

    return 0;
}
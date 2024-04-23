#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    int n;
    cin >> n;
    vector<int> tree(n);
    for(int i = 0; i<n; i++){
        cin >> tree[i];
    }
    sort(tree.begin(), tree.end(), greater<>());
    int ans = 0;
    for(int i = 0; i<n; i++){
        ans = max(ans, tree[i]+i+2);
    }
    cout << ans;

    return 0;
}
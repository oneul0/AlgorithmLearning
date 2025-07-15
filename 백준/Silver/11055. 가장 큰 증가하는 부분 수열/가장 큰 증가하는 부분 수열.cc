#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main(){
    cin.tie(0) -> ios_base::sync_with_stdio(false);
    int n;
    
    cin >> n;
    vector<int> arr(n);
    for(int i = 0; i<n; i++){
        cin >> arr[i];
    }

    vector<int> dp(n,0);
    for(int i = 0; i<n; i++){
        dp[i] = arr[i];
    }
    for(int i = 0; i<n; i++){
        for(int j = 0; j<i; j++){
            if(arr[j] < arr[i]) {
                dp[i] = max(dp[i], dp[j]+arr[i]);
            }
        }
    }
    int ans = 0;
    for(int i = 0; i<n; i++){
        ans = max(ans, dp[i]);
    }
    cout << ans;

    return 0;
}
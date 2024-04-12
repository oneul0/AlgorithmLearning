#include <iostream>
using namespace std;
const int MAX = 10003;
int n, glass[MAX] = {0}, dp[MAX] = {0};

int main(){
    cin >> n;
    for(int i = 3; i<n+3; i++){
        cin >> glass[i];
    }

    for(int i = 3; i<n+3; i++){
        int tmp = max(dp[i-3] + glass[i-1] + glass[i], dp[i-2]+glass[i]);
        dp[i] = max(tmp, dp[i-1]);
    }
    
    cout << dp[n+2];
    return 0;
}
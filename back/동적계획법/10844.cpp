#include <iostream>

using namespace std;

const int mod = 1000000000;

int N, dp[101][10];

int main(){
    cin >> N;
    for(int i = 1; i<=9; i++){
        dp[1][i] = 1;
    }
    for(int i = 2; i<=N; i++){
        for(int j = 0; j<=9; j++){
            if(j==0) dp[i][j] = dp[i-1][1];
            else if(j == 9) dp[i][j] = dp[i-1][8];
            else dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1];
            dp[i][j] = dp[i][j] % mod;
        }
    }

    int ans = 0;
    for(int i = 0; i<=9; i++){
        ans = (ans + dp[N][i]) % mod;
    }
    cout << ans;
}
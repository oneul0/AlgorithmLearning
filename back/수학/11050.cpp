#include <iostream>
#include <algorithm>

using namespace std;

int a,b;
int dp[20][20] = {0};
//이항계수 공식
//nCr = n-1Cr-1 + n-1Cr;
int binomial(int n, int r){
    for(int i = 0; i<=n; i++)
        for(int j = 0; j<= min(r,i); j++){
            if(i == j || j == 0) dp[i][j] = 1;
            else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
        }
    
    return dp[n][r];
}


int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> a >>b;
    binomial(a,b);
    cout << dp[a][b];
    return 0;
}
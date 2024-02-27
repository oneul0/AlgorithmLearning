#include <iostream>
#include <cmath>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int n, i, j, minNum, DP[50002] = {0,1};
    cin >> n;

    for(DP[50001] = 4, i = 2; i<=n; i++){
        minNum = 50001;
        for(j = 1; j*j<=i; j++){
            if(DP[i-j*j]<DP[minNum]){
                minNum = i-j*j;
            }
        }
        DP[i] = DP[minNum]+1;
    }
    cout << DP[n];
}
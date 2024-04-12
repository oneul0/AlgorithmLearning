#include <iostream>
#include <algorithm>

using namespace std;

int N, A[1001] = {0}, dp[1001] = {0};
int main(){
    cin >> N;
    for(int i = 0; i<N; i++){
        cin >> A[i];
    }

    for(int i = 0; i<N; i++){
        dp[i] = 1;
        for(int j = 0; j<i; j++){
            if(A[j]<A[i]){
                dp[i] = max(dp[i], dp[j]+1);
                //cout<< "i : "<< i << " dp[i] : " << dp[i] << " dp[j] : "<< dp[j] << endl;
            }
        }
    }
    cout << *max_element(dp, dp+N);
    return 0;
}
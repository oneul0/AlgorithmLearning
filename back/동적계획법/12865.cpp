#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N,K,DP[101][100001],W[101],V[101];

int main(){
    cin >> N >>K;
    for(int i = 1; i<=N; i++)
        cin >> W[i] >> V[i];

    for(int i = 1; i<=N; i++){
        for(int j = 1; j<=K; j++){
            //i번째 아이템까지 고려했을 때 최대 j무게까지 최대값
            if(j-W[i] >= 0)
                DP[i][j] = max(DP[i-1][j], DP[i-1][j-W[i]]+V[i]);
            else
                DP[i][j] = DP[i-1][j];
        }
    }
  
    cout << DP[N][K];
    return 0;
}
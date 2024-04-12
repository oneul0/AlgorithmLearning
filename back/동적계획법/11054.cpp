#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int N;
    cin >> N;
    vector<int> A(N), dp_left(N+1), dp_right(N+1), dp(N+1);
    for(int i = 0; i<N; i++){ cin >> A[i]; }
    //i가 중간 수가 될 때의 길이를 dp에 저장하고 dp의 최대 값 찾기
    for(int i = 0; i<N; i++){
        dp_left[i] = 1;
        for(int j = 0; j<i; j++){
            if(A[j] < A[i]){
                dp_left[i] = max(dp_left[i], dp_left[j]+1);
            }
        }
    }
    for(int i = N-1; i>=0; i--){
        dp_right[i] = 1;
        for(int j = N-1; j>=i; j--){
            if(A[j] < A[i]){
                dp_right[i] = max(dp_right[i], dp_right[j]+1);
            }
        }
    }
    int ans = 0;
    for(int i = 0; i<N; i++){
        int tmp = dp_left[i]+dp_right[i]-1;
        if(tmp > ans){ ans = tmp; }
    }
    cout << ans;

    return 0;
}
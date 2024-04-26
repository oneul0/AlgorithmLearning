#include <iostream>
#include <cmath>
#include <algorithm>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false); cin.tie(0);
    int T;
    cin >> T;
    for(int i = 0; i<T; i++){
        int arr[6];
        for(int j = 0; j<6;j++){
            cin >> arr[j];
        }
        //반지름의 차
        float dif = abs(arr[5]-arr[2]);
        //반지름의 합
        float sum = abs(arr[5]+arr[2]);
        //두 점 사이의 거리
        float dist  = sqrt(pow(arr[3]-arr[0],2)+pow(arr[4]-arr[1],2));
        int ans = -1;
        if(dist == 0 && arr[5]==arr[2]){cout << ans << '\n'; continue;}
        if(dist == sum || dist == dif){ ans = 1; } // 외접 혹은 내접
        else if(dist > dif && dist < sum){ ans = 2; } // 두 점
        else if(dist > sum || dist < dif){ ans = 0;} // 내부
        // dist > sum인 경우 -> 외부
        cout << ans << '\n';
    }
    return 0;
}
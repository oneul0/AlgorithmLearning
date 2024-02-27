#include <iostream>
#include <algorithm>

using namespace std;

string s;
int N, arr[10] = {}, ans = 0;
int main(){
    for(int i = 0; i<=9; i++) arr[i] = 0;
    cin >> s;
    for(char c: s){
        int num  = c - '0';
        arr[num]++;
    }
    for(int i = 0; i < 10; i++){
        if(i == 6 || i == 9) continue;
            ans = max(ans, arr[i]);
    }
  // (a[6]+a[9])/2를 올림한 값이 6, 9에 대한 필요한 세트의 수이므로 (a[6]+a[9]+1)/2을 계산
    ans = max(ans, (arr[6]+arr[9]+1)/2);
    cout << ans;
    return 0;
}
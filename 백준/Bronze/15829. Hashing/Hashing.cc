#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main(){
    const int R = 31;
    const int MOD = 1234567891;

    string str;
    int n;
    long ans = 0;
    cin >> n >> str;
    for(int i = 0; i<str.length(); i++){
        long char_val = str[i]-96;
        long calc_r = pow(R, i);
        calc_r %= MOD;
        ans += ((char_val)*(calc_r)%MOD);
        ans %= MOD;
    }
    cout << ans;
    return 0;
}
//as는 97
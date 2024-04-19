#include <iostream>
#include <iomanip>
#include <vector>
#include <string>
#define ll long long
using namespace std;
const ll MAX = 1000000000;
ll gcd(ll a, ll b) {
    while (b != 0) {
        ll tmp = b;
        b = a % b;
        a = tmp;
    }
    return a;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);

    ll n, m;
    cin >> n;
    vector<ll> nums(n);
    for (int i = 0; i < n; i++) {
        cin >> nums[i];
    }

    cin >> m;
    vector<ll> mums(m);
    for (int i = 0; i < m; i++) {
        cin >> mums[i];
    }
    ll ans = 1; bool chk = false;
    for(int i =0; i<n; i++){
        for(int j = 0; j<m; j++){
            ll gc = gcd(nums[i], mums[j]);
            ans *= gc;
            if(ans>=MAX){
                ans %= MAX;
                chk = true;
            }
            nums[i] /= gc;
            mums[j] /= gc;
        }
    }

    if(chk){
        ans %= MAX;
        cout.width(9);
        cout.fill('0');
    }
    cout << ans;

    return 0;
}

#include <iostream>
#include <vector>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    size_t n;
    cin >> n;

    vector<int> cnt(n+1);
    cnt[1] = 0;
    for(int i = 2 ; i<=n; i++){
        cnt[i] = cnt[i-1]+1;
        if(i%3 == 0) cnt[i] = min(cnt[i], cnt[i/3]+1);
        if(i%2 == 0) cnt[i] = min(cnt[i], cnt[i/2]+1);
    }
    
    cout << cnt[n];
    return 0;
}
#include <iostream>
#include <cmath>
#include <algorithm>

using namespace std;

int main(){
    int x,y,w,h,ans;
    cin >> x >> y >> w >> h;

    ans = min({abs(x-w), abs(y-h), x,y});
    cout << ans;
    return 0;
}
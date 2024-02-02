#include <iostream>

using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int num;
    cin >> num;
    int ans =1;
    for(int i = num; i>=1; i--)
        ans *= i;
    cout << ans;
    return 0;
}
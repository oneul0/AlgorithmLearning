#include <iostream>
using namespace std;

int main() {
    int sum = 0;
    int cnt = 0;

    for (int i = 0; i < 10; i++) {
        int x;
        cin >> x;
        if (x >= 250) break;
        sum += x;
        cnt++;
    }

    cout << sum << " ";
    cout << fixed;
    cout.precision(1);

    if (cnt > 0) cout << (double)sum / cnt;
    else cout << 0.0;

    return 0;
}
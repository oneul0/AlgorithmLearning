#include <iostream>
using namespace std;

int main() {
    int a1, a2;
    int b1, b2;
    cin >> a1 >> a2;
    cin >> b1 >> b2;
    if(a1 > b1 && a2 > b2) cout << 1;
    else cout << 0;
    return 0;
}
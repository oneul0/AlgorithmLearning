#include <iostream>
#include <cmath>
using namespace std;

int main() {
    int a, b, c;
    cin >> a>> b>>c;
    int minVal = min(a,min(b,c));
    if(a==minVal) cout << 1;
    else cout << 0;
    cout << " ";
    if(a == b && b==c) cout << 1;
    else cout << 0;
    return 0;
}
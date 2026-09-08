#include <iostream>
using namespace std;

int main() {
    int A;
    cin >> A;
    if(A % 2 == 1) A+=3;
    if(A % 3 == 0) A/=3;
    cout << A;
    return 0;
}
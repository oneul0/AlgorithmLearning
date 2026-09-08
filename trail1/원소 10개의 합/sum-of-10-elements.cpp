#include <iostream>
using namespace std;

int main() {
    int a = 0;
    for(int i =0 ; i<10; i++){
        int tmp = 0;
        cin >> tmp;
        a += tmp;
    }
    cout << a;
    return 0;
}
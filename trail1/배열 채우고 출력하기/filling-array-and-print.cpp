#include <vector>
#include <iostream>
using namespace std;

int main() {
    vector<char> v;
    v.resize(10, 0);
    for(int i = 0; i<10; i++){
        cin >> v[i];
    }
    for(int i = 9; i>=0; i--){
        cout << v[i]<<"";
    }
    return 0;
}
#include <iostream>

using namespace std;

int main(){
    int v[6] = {1,1,2,2,2,8};
    for(int i = 0; i<6; i++){
        int num;
        cin >> num;
        v[i] -= num;
    }
    for(auto a : v){
        cout << a<<" ";
    }
    return 0;
}
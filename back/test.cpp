#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int a;

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    cin >> a;
    int* arr = new int[a]{1,2,3,4,5};
    cout << a<<" ";
cout << '\n';
    for(int i = 0; i<a; i++){
        cout << arr[i] <<" ";
    }
    cout << '\n';
    delete[] arr;
    for(int i = 0; i<a; i++){
        cout << arr[i] <<" ";
    }
    return 0;
}
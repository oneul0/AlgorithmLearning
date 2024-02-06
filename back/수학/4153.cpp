#include <iostream>
#include <algorithm>
#include <cmath>

using namespace std;
int arr[3];
int a, b, c;
string s;
int main(){
    while(1){
        cin >>a >> b >> c;
        int arr[3] = {a, b, c};
        if(a == 0) break;
        
        sort(arr, arr+3);
        a = pow(arr[0], 2);
        b = pow(arr[1], 2);
        c = pow(arr[2], 2);
        s = (a + b == c) ? "right" : "wrong";
        cout << s <<'\n';
    }
    

    return 0;
}
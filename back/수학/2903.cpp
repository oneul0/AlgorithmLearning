#include <iostream>
#include<cmath>
using namespace std;

int main(){
    int n;
    
    cin >> n;
    int dots = 2;
    while(n--){
        dots += (dots-1);
    }
    
    int ans = pow(dots,2);
    cout << ans;
    return 0;
}


#include <iostream>
#include <vector>

using namespace std;



int gcd(int a, int b){
    while(b!=0){
        int tmp = b;
        b = a%b;
        a = tmp;
    }
    return a;
}

int lcm(int a, int b){
    return (a*b)/gcd(a,b);
}


int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    int a, b;
    int n;
    cin >> n;
    while(n--){
        cin >> a >> b;
        cout << lcm(a,b)<<'\n';
    }
        
    return 0;
}
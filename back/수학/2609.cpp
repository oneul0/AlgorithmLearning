#include <iostream>

using namespace std;

int a, b, gcdNum = 0, lcmNum=0;

int gcd(int a, int b){
    if(b == 0) return a;
    else return gcd(b, a%b);
}

int lcm(int a, int b){
    int lcm_num;
    lcm_num = (a*b)/gcdNum;
    return lcm_num;
}

int main(){
    ios_base::sync_with_stdio(0);
    cin >> a >> b;
    gcdNum = gcd(a, b);
    lcmNum = lcm(a, b);
    cout << gcdNum << '\n' << lcmNum;
    return 0;
}
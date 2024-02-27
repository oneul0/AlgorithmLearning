#include <iostream>
#include <vector>

using namespace std;

int main(){
    int n;
    cin >>n;
    if(n%2 == 1) cout << "SK";
    else cout <<"CY";

    return 0;
}

//n%3 == 0 -> SK
    //n%4 == 0 -> CY
    //n%5 == 0 -> SK
    //n%6 == 0 -> CY
    //n%7 == 0 -> SK
    // n%8 == 0 -> CY
    // => 홀수 = CY 짝수 = SK
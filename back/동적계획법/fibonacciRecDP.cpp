#include <iostream>
#include <vector>

using namespace std;

vector<int> fibonacciNums(100,-1);

int fibonacci(int n){
    cout << "called : "<<n<< endl;

    if(fibonacciNums[n] == -1){
        if(n == 0){fibonacciNums[n] =0;}
        else if(n == 1){ fibonacciNums[n] = 1;}
        else{
            fibonacciNums[n] = fibonacci(n-1) + fibonacci(n-2);
        }
    }
    return fibonacciNums[n];
}

int main(){
    cout << fibonacci(5);
    return 0;
}
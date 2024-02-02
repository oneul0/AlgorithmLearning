#include <iostream>
#include <vector>

using namespace std;

vector<int> fibonacciNums(100,0);

int fibonacci(int n){
    for(int i = 0; i<=n; i++){
        if(i == 0){ fibonacciNums[i] = 0; }
        else if(i == 1){ fibonacciNums[i] = 1; }
        else{
            fibonacciNums[i] = fibonacciNums[i-1]+fibonacciNums[i-2];
        }
    }
    return fibonacciNums[n];
}

int main(){
    for(int n = 0; n<=8; n++){
        cout << fibonacci(n) <<" ";
    }
    return 0;
}
#include<iostream>
#include<vector>

using namespace std;


int n;
int f[41];
int fcnt = 0;
int cnt = 0;
int fib(int n){
    cnt++;
    if(n == 1 || n ==2){
        return 1;
    }
    else{
        return fib(n-1) + fib(n-2);
    }
}

int fibonacci(int n){
    fcnt++;
    if(n ==1 || n ==2){
        f[n] = 1;
        return 1;
    }
    for(int i = 3; i<n; i++){
        f[i] = f[i-1]+f[i-2];
    }
    return f[n];
}

int main(){
    cin >> n;

    fib(n);
    fibonacci(n);

    cout << cnt <<" "<<fcnt;



    return 0;
}
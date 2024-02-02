#include <iostream>
#include <vector>

using namespace std;

vector<int> v;
int cnt = 0; int cnt2=0;

int fib(int n){
    if(n == 1 || n ==2){
        
    cnt++;
        return 1;
    }
    else{
        return fib(n-1) + fib(n-2);
    }
}

int fibonacci(int n){
    cnt2++;
    v[1]=1 ,v[2] = 1;
    for(int i = 3; i<n; i++){
        cnt2++;
        v.push_back(v[i-1]+v[i-2]);
    }
    return v[n];
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(0);
    int n;
    cin >> n;
    v.resize(3,1);
    fib(n); fibonacci(n);
    cout << cnt << " " << cnt2;
    return 0;
}
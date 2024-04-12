#include <iostream>
#include <vector>

using namespace std;

int T,N;
int ans[2] = {0};
vector<int> fibo(41,0);
int fibonacci(int n){
    if(n<2) ans[n]++;
    if(n==0){
        return 0;
    }
    else if(n==1){
        return 1;
    }
    else{
        return fibonacci(n-1)+fibonacci(n-2);
    }
    
}
void fibonnaci(int n){
    for(int i = 2; i<=n; i++){
        if(i==0||i == 1||i==2)
    }
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    cin >>T;
    fibo[1] = fibo[2] = 1;
    
    for(int i = 0; i<T; i++){
        fill_n(ans,2,0);
        cin >> N;

        fibonacci(N);
        cout<<ans[0]<<" "<<ans[1]<<'\n';
    }
    return 0;
}
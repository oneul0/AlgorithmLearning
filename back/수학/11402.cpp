#include <iostream>
#include <vector>
using namespace std;
using ll = long long;

int main(){
    ll n, k, p;  
    cin >> n >> k >> p;  
    
    //pCp까지의 값을 구함
    vector<vector<int>> binom(p + 1, vector<int>(p + 1));  
    
    for (int i = 0; i <= p; i++)  
        for (int j = 0; j <= i; j++)  
            binom[i][j] = !i || !j ? 1 : (binom[i - 1][j] + binom[i - 1][j - 1]) % p;  
    
    //n과 k를 0이 될 때 까지 p로 나눠두며 n%p C n % p (mod p)를 정답에 곱해줌
    ll ret = 1;  
    while (n || k) {  
        ret = (ret * binom[n % p][k % p]) % p;  
        n /= p, k /= p;  
    }  
    
    cout << ret;  
    return 0;
}

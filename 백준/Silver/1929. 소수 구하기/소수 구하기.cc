#include <iostream>
#include <vector>
//에라토스테네스의 체
using namespace std;
int m, n;
vector<bool> v;
void isPrime(){
    for(int i = 2; i*i<=n; i++)
        if(v[i])
            for(int j = i*i; j<=n; j+=i)
                v[j] = false;
}

int main(){
    cin >> m >> n;
    v.resize(n+1, true);
    v[0] = v[1] = false;
    isPrime();
    //for(int i = 0; i<m; i++) v[i] = false;
    for(int i = m; i<=n; i++){
        if(v[i]) cout << i << "\n";
    }
    return 0;
}
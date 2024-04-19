#include <iostream>

using namespace std;
const int mod = 1000000;

long long CSOD(int n)
{
    long long sum=0;
    for(long long i = 2; i*i<=n; i++)
    {
        long long j = n/i;
        sum += i * (j - i + 1) + (j - i) * (j + i + 1) / 2;
    }
    return sum%mod;
}

int main(){
    int n;
    cin >> n;
    cout << CSOD(n);   

    return 0;
}
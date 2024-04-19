#include <iostream>
#include <queue>
#define ll long long

using namespace std;
const int mod = 1000000;
const int p = 15*(mod/10);
ll n;
queue<ll> q;
void fibo(ll n){
    ll cnt = 2;
    while(cnt < n){
        ll F = 0;
        F =(F + q.front()); //F(n-1)
        q.pop();
        F =(F + q.front())%mod; //F(n-2)
        q.push(F);
        cnt++;

    }
    cout << q.front();
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n;
    q.push(1);
    q.push(2);
    fibo(n%p);
    return 0;
}
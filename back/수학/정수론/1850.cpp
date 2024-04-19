#include <iostream>
#include <vector>
#include <algorithm>
#define ll long long
using namespace std;
ll A, B;
string ans="";

ll gcd(ll A, ll B){
    while(B != 0){
        ll tmp = B; //연산자의 값(다음으로 나눌 값)을 임시로 들고 있음
        B = A % B;//나머지 결과 값
        A = tmp;//피연산자
    }
    return A;
}


int main(){
    cin >> A >> B;
    string s="";
    ll roop = gcd(A,B);
    for(ll i = 0; i<roop; i++){
        s+="1";
    }
    
    cout << s;
    return 0;
}
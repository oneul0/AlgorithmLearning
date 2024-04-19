#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

vector<bool> prime(int n){
    vector<bool> isPrime(n+1,true);
    isPrime[0] = isPrime[1] = false;

    for(int i = 2; i*i<=n; i++){
        if(isPrime[i]){
            for(int j = i*i; j<=n; j+=i){
                isPrime[j] = false;
            }
        }
    }
    return isPrime;
}

void permutation(string s, vector<int> v, int len){
    int idx = 0;
    if(idx == len){
        for(int i = 0; i<len; i++){
            
        }
    }
}

int solution(string numbers) {
    int answer = 0;
    vector<int> v;
    for(char c : numbers){
        v.push_back(c-'0');
    }
    sort(v.begin(), v.end());
    vector<bool> isPrime = prime(v[0]);
    //Permutation 구하기

    return answer;
}

int main(){

    cout << solution("17");
}
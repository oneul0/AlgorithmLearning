#include <iostream>
#include <string>
#include <algorithm>


using namespace std;


int main(){
    string n;
    cin >> n;
    sort(n.begin(), n.end(), greater<>());
    if(n[n.length()-1] != '0') cout << -1;
    else{
        int sum = 0;
        for(char c: n){
            sum += (c-'0');
        }
        if(sum % 3 == 0) cout << n;
        else cout << -1;
    }
    return 0;
}
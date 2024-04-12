#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    string s;
    while (1)
    {
        getline(cin,s);
        if(s == "END") break;
        string ans = "";
        for(int i = s.length()-1; i>=0; i--){
            ans += s[i];
        }
        cout << ans<<'\n';
    }
    
    return 0;
}
#include <iostream>
#include <string>
#include<algorithm>
#include <bitset>

//공부좀 해보기
using namespace std;

string trans(char c) {
    int n = c - '0';
    string binary = bitset<3>(n).to_string();
    return binary;
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    string s;
    string ans ="";
    bool chk = false;
    cin >> s;
    if(s == "0"){
        chk = true;
    }
    for(char& c: s){
        ans += trans(c);
    }
    for(int i=0; i<2; i++){
        if(ans[0]=='0' && ans.size()>1 ){
            ans.erase(0,1);
        }
    }
        
    if(chk){ans = "0";}
    cout << ans;

    return 0;
}

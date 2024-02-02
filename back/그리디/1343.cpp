#include <iostream>
#include <vector>
#include<string>
#include<sstream>
#include <algorithm>




using namespace std;

int main(){
    ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
    vector<string> v;

    string s;

    cin >> s;
    size_t cur = 0;

    while(cur != string::npos){
        cur = s.find("XXXX");
        if(cur != string::npos){
            s.replace(cur, 4, "AAAA");
        }
    }
    cur = 0;
    while(cur != string::npos){
        cur = s.find("XX");
        if(cur != string::npos){
            s.replace(cur, 2, "BB");
        }
    }

    cur = s.find("X");
    if(cur == string::npos){
        cout << s;
    }
    else{
        cout << -1;
    }
    
    return 0;
}

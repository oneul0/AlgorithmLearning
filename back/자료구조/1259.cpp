#include <iostream>
#include <deque>
#include <string>

using namespace std;

int n[5];
string s;

bool chk;
void check(string s){
    deque<char> dq;
    chk = true;
    for(auto& c : s){
        dq.push_back(c);
    }
    int ds = dq.size()/2;
    while(ds--){
        char df = dq.front();
        char de = dq.back();
        dq.pop_front();
        dq.pop_back();
        //cout << df <<" "<< de<<" ";
        if(df != de) chk = false;
    }
    
}

int main(){
    while(1){
        cin >> s;
        if(s == "0") break;
        check(s);
        if(chk) cout << "yes"<<'\n';
        else cout << "no" << '\n';
    }
    return 0;
}
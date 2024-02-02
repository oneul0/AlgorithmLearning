#include<iostream>
#include<string>
#include<vector>

using namespace std;

int main(){
    vector<int> v(26,0);
    //97~122
    string s;
    cin >> s;
    for(char c : s){
        int chint = c;
        v[chint-97] += 1;
    }
    for(auto& i : v){
        cout << i << '\n';
    }
    return 0;
}
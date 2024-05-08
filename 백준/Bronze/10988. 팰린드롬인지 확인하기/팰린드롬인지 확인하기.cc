#include<iostream>
#include<vector>
#include<string>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false); cin.tie(0), cout.tie(0);
    string word;
    vector<char> v;
    int right, middle;
    bool chk = false;

    cin >> word;
    for(char c: word){
        v.push_back(c);
    }

    right = v.size()-1;
    middle = right/2;

    for(int i = 0; i<=middle; i++){
        if(v[i] != v[right-i]){ cout << 0; return 0;}
    }
    cout << 1;

    return 0;
}
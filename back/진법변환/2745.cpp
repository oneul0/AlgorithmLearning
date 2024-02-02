#include<iostream>
#include<vector>
#include<string>

using namespace std;

int main(){
    int b;
    string n;
    vector<char> v;
    cin >> n >> b;

    for(char c : n){
        v.push_back(c);
    }
    

    return 0;
}
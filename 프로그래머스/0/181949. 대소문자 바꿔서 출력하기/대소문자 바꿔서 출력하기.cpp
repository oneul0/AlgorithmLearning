#include <iostream>
#include <string>

using namespace std;

int main(void) {
    string str;
    cin >> str;
    for(char& c : str){
        if('A' <= c && c <= 'Z') c += 32;
        else c-=32;
    }
    cout << str;
    return 0;
}
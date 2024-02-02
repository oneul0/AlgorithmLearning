#include <iostream>
#include <string>
#include <cstring>
using namespace std;


int main(){
    
    string S;
    char c[1001];
    int i;

    cin >> S;
    cin >> i;
    
    strcpy(c,S.c_str());

    cout << c[i-1];


    return 0;
}
#include <iostream>
#include <string>
using namespace std;
int main(){
    int A,B,C;
    cin >> A >> B >> C;
    cout << (A+B-C) << endl;
    string tmp = to_string(A)+to_string(B);
    cout << stoi(tmp)-C;
}
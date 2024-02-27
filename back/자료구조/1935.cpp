#include <iostream>
#include <map>
#include <stack>

using namespace std;

int n, num, asci;
string s;
stack<int> tmp;
map<char, int> ops;
int main(){
    cin >> n >> s;
    while(n--){
        cin >> num;
        tmp.push(num);
    }
    //연산자 map에 숫자 매핑
    while(!tmp.empty()){
        for(char& c: s){
            asci = c;
            //영단어이면
            if(asci>=65 &&asci<=90){
                ops[c] = tmp.top();
                tmp.pop();
            }
        }
    }
    return 0;
}

//ABC*+DE/-
/*
ABC
*+
DE
/-
(A(BC*)+)((DE/)-)
*/
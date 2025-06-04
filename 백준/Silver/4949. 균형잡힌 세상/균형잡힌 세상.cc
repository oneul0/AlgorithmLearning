#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int main(){
    while(1){
        string str = "";
        stack<char> st;
        int flag = 1;
        getline(cin, str);
        if(str.length() == 1 && str == ".") break;
        for(int i = 0; i<str.length(); i++){
            char c = str[i];
            if(i == 0 && c == '.') {
                flag = -1;
                break;
            }
            if(st.empty() && (c == ')' || c==']')){
                flag = 0;
                break;
            }
            if(c == '(' || c == '['){
                st.push(c);
            }
            else if (c == ')') {
                if (st.empty() || st.top() != '(') {
                    flag = 0;
                    break; 
                }
                st.pop();
            } 
            else if (c == ']') {
                if (st.empty() || st.top() != '[') {
                    flag = 0;
                    break;
                }
                st.pop();
            }
        }
        if(!st.empty()) flag = 0;
        if(flag == 0) cout << "no"<<endl; 
        else if(flag == 1) cout<<"yes"<<endl;
    }

    return 0;
}
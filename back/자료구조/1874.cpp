#include <iostream>
#include <stack>
#include <queue>
using namespace std;

int n, a, num = 1;
stack<int> stk;
queue<char> ans;

int main(){
    cin >> n;
    
    for(int i = 0; i<n; i++){
        cin >> a;
        if(!stk.empty() && stk.top() == a){
            stk.pop();
            ans.push('-');
        }
        else if(num <=a){
            while(num <= a){
                stk.push(num++);
                ans.push('+');
            }
            stk.pop();
            ans.push('-');
        }
        else if(!stk.empty() && stk.top() > a){
            cout << "NO";
            return 0;
        }
    }
    while(!ans.empty()){
        cout << ans.front() << "\n";
        ans.pop();
    }
   
    return 0;
}
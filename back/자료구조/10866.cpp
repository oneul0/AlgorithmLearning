#include <iostream>
#include <deque>

using namespace std;

int n, k;
deque<int> dq;
string s;
void deque_update(string s){
    if(s == "push_front"){
        cin >> k;
        dq.push_front(k);
    }
    else if(s == "push_back"){
        cin >> k;
        dq.push_back(k);
    }
    else if(s == "pop_front"){
        k = dq.front();
        dq.pop_front();
        cout << k << '\n';
    }
    else if(s == "pop_back"){
        k = dq.back();
        dq.pop_back();
        cout << k << '\n';
    }
    else if(s == "size") cout << dq.size() << '\n';
    else if(s == "empty") cout << dq.empty() << '\n';
    else if(s == "front") cout << dq.front() << '\n';
    else if(s == "back") cout << dq.back() << '\n';
}


int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n;
    while(n--){
        cin >> s;
        if(!dq.empty() || s == "push_front" || s=="push_back" || s == "size" || s=="empty") deque_update(s);
        else cout << -1 << '\n';
    }
    return 0;
}
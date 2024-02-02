#include <iostream>
#include <queue>

using namespace std;

queue<int> q;

void rqst(string s){
    int num;
    if(s == "push"){
        cin >> num;
        q.push(num);
    }
    else if(s == "pop"){
        if(q.empty()) cout << -1<<'\n';
        else{
            num = q.front();
            q.pop();
            cout << num << '\n';
        }
    }
    else if(s == "size")
        cout << q.size() << '\n';

    else if(s == "empty")
        cout << q.empty() << '\n';
    
    else if(s == "front"){
        if(q.empty()){ num = -1; }
        else{ num = q.front(); }
        cout << num << '\n';
    }
    else if(s == "back"){
        if(q.empty()){ num = -1; }
        else{ num = q.back(); }
        cout << num << '\n';
    }
    //cout << "request done"<<'\n';
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(0);
    int n;
    cin >> n;

    string s;
    while(n--){
        cin >> s;
        rqst(s);
    }
    return 0;
}
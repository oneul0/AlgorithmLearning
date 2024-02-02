#include <iostream>
#include <queue>

using namespace std;

queue<int> q;
int n, k;
string s;

void queue_update(string s){
    if(s == "push"){
        cin >>k;
        q.push(k);
    }
    else if(!q.empty() && s == "pop"){
        int v = q.front();
        q.pop();
        cout << v << '\n';
    }
    else if(!q.empty() && s == "front") cout << q.front() << '\n';
    else if(!q.empty() && s == "back") cout << q.back() << '\n';
    else if(s == "empty") cout << q.empty() << '\n';
    else if(s == "size") cout << q.size() << '\n';
    else {
        cout << -1 << '\n';
    }
}


int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n;
    for(int i= 0; i<n; i++){
        cin >> s;
        queue_update(s);
    }
    return 0;
}
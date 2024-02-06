#include <iostream>
#include <queue>

using namespace std;

int n, topNum = 1;
queue<int> q;
int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n;
    for(int i =1; i<=n; i++){
        q.push(i);
    }
    while(!q.empty()){
        q.pop();
        if(q.empty()){
            break;
        }
        topNum =q.front();
        q.pop();
        
        q.push(topNum); 
    }
    cout << topNum << '\n';
    return 0;
}
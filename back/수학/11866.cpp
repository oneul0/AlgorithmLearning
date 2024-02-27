#include <iostream>
#include <queue>

using namespace std;

int n,k, cnt = 0, tmp;
queue<int> q, ans;
int main(){
    cin >> n >> k;
    for(int i = 1; i<=n; i++){
        q.push(i);
    }
    cout <<"<";
    while(q.size() != 1){
        cnt++;
        tmp = q.front();
        q.pop();
        if(cnt == k){
            cout << tmp << ", ";
            cnt = 0;
        }
        else q.push(tmp);
    }
    cout << q.front();
    cout << ">";
    return 0;
}
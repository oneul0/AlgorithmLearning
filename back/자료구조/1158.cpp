#include <iostream>
#include <queue>

using namespace std;

int N, K, tmp, cnt = 0;
queue<int> q, ans;
int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> K;
    for(int i = 1; i<=N; i++){
        q.push(i);
    }
    while(!q.empty()){
        cnt++;
        tmp = q.front();
        q.pop();
        if(cnt == K){
            ans.push(tmp);
            cnt = 0;
            continue;
        }
        q.push(tmp);
    }

    cout <<"<";
    for(int i = 0; i<N-1; i++){
        cout << ans.front() << ", ";
        ans.pop();
    }
    cout << ans.front() <<">";
    return 0;
}
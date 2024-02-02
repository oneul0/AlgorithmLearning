#include <iostream>
#include <queue>

using namespace std;


int T, N, M, P = 0, doc, ans;

struct cmp
{
    bool operator()(pair<int, int>&a, pair<int, int>&b){
        if(a.second == b.second){
            return a.first > b.first;
        }
        else{
            return a.second < b.second;
        }
        
    }
};


int main(){
    cin >> T;
    while(T--){
        ans = 0;
        priority_queue<pair<int,int>,vector<pair<int,int>>, cmp> pq;
        cin >> N >> M;
        for(int i = 0; i<N; i++){
            cin >> doc;
            pq.push(make_pair(i,doc));
        }
// while(!pq.empty()){
//         cout << pq.top().first << pq.top().second << endl;
//         pq.pop();
//     }
        while(!pq.empty()){
            int tmp = pq.top().first;
            pq.pop();
            ans++;
            if(tmp == M){
                cout << ans<<'\n';
            }
        }
        

    }
    return 0;
}
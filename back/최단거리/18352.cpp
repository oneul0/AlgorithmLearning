#include <iostream>
#include <vector>
#include <queue>
#include <climits>
using namespace std;

#define INF INT_MAX

int N, M, K, X, A, B, loc, cost;
vector<vector<pair<int,int>>> v;
vector<int> dist;
priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;

void init_func(int X){
    v.resize(N+1);
    dist.resize(N+1, INF);
    dist[X] = 0;
    pq.push(make_pair(0,X));
}

void dajkstra(int sx){
    while(!pq.empty()){
        cost = pq.top().first;
        loc = pq.top().second;
        pq.pop();
        if(dist[loc]<cost) continue;
        for(auto& p : v[loc]){
            int current_cost = cost+p.first;
            if(current_cost < dist[p.second]){
                dist[p.second] = current_cost;
                pq.push(make_pair(current_cost, p.second));
            }
        }
    }
    

}
//비용을 거리로 사용
int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N >> M >> K >> X;
    
    init_func(X);

    for(int i = 0; i<M; i++){
        cin >> A >> B;
        v[A].push_back(make_pair(1,B));
        
    }

    dajkstra(X);
    int cnt = 0;
    bool chk = false;
    for(auto& d : dist){
        
        if(d == K){
            cout << cnt << '\n';
            chk = true;
        }
        cnt++;
    }
    if(!chk){
       cout << "-1";
    }

    return 0;
}
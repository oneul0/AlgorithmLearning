#include <iostream>
#include <vector>
#include <algorithm>
#include <limits>
#include <queue>
using namespace std;

const long long int INF = 1000000000;

int N,E, v1, v2;
vector<vector<pair<int,int>>> graph;
vector<bool> visited;
vector<int> dist;
vector<bool> vchk;

    
void dijkstra(int s){
    dist.assign(N+1, INF);
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    dist[s] = 0;
    pq.push({0,s});
    while(!pq.empty()){
        int cur_dist = pq.top().first;
        int cur_node = pq.top().second;
        pq.pop();
        
        for(const pair<int,int> nxt : graph[cur_node]){
            int nxt_dist = nxt.second;
            int nxt_node = nxt.first;
            if(dist[nxt_node] > cur_dist+nxt_dist){
                dist[nxt_node] = cur_dist+nxt_dist;
                pq.push({dist[nxt_node], nxt_node});
            }
        }
    }
}


int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    cin >> N >> E;
    graph.resize(N+1); dist.resize(N+1, INF);

    for(int i = 0; i<E; i++){
        int a,b,cost;
        cin >> a >> b >> cost;
        graph[a].push_back({b, cost});
        graph[b].push_back({a, cost});
    }
    cin >> v1 >> v2;
    
    long long int v1_1, v1_v2,v1_n,v2_1,v2_n;
    dijkstra(v1);
    v1_1 = dist[1];
    v1_v2 = dist[v2];
    v1_n = dist[N];

    dijkstra(v2);
    v2_1 = dist[1];
    v2_n = dist[N];
    long long int ans1 = v1_1 + v1_v2 + v2_n;
	long long int ans2 = v2_1 + v1_v2 + v1_n;
	long long int ans = ans1 < ans2 ? ans1 : ans2;
    if(ans>=INF) ans = -1;
    cout << ans;
    return 0;
}
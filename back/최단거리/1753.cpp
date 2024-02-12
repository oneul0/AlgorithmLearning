#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;
#define INF INT_MAX
int v, e, k, node, line, w;
vector<vector<pair<int,int>>> g;
queue<int> preNodes;
priority_queue<pair<int,int>, vector<pair<int,int>>, cmp> nxtNodes;
vector<int> dist;

struct cmp
{
    bool operator()(pair<int,int>& a, pair<int,int>& b){
        if(a.second == b.second){
            return a.first<b.first;
        }
        else{
            return a.second<b.second;
        }
    }
};

void dijkstra(int sx){
    if(sx == k) dist[sx] = 0;
    for(auto& a : g[sx])
        nxtNodes.push(a);
    int crnt = sx;
    while(!nxtNodes.empty()){
        pair<int,int> tmp = nxtNodes.top();
        if(dist[crnt]+tmp.second < dist[tmp.first]){
            dist[tmp.first] = dist[crnt]+tmp.second;
        }
    }
    
}




int main(){
    cin >> v >> e >> k;
    g.resize(v);
    dist.resize(v+1, INF);
    for(int i =0; i<e; i++){
        cin >> node >> line >> w;
        g[node].push_back(make_pair(line, w));
    }
    
    //for(int i = 1; i<=v; i++)
    dijkstra(k);

    for(int i = 1; i<=v; i++){
        if(dist[i] == INF) cout << "INF"<<'\n';
        else cout << dist[i] << '\n';
    }
    return 0;
}
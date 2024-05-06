#include <iostream>
#include <vector>
#include <algorithm>
#include <limits>

using namespace std;
const long long MAX = INT32_MAX;
int N,M,a,b,c;
vector<pair<int, pair<int,int>>> city;
vector<long long> dist(501,MAX);

bool bellmanFord(int sx){
    dist[sx] = 0;

    for(int i = 1; i<=N; i++){
        for(int j = 0; j<M; j++){
            int from = city[j].first;
            int to = city[j].second.first;
            int cost = city[j].second.second;

            if(dist[from] == MAX) continue;

            if(dist[to] > dist[from] + cost){
                dist[to] = dist[from] + cost;

                if(i == N) return true;
            }
        }
        
    }
    return false;
}

int main(){
    cin >> N >> M;
    for(int i = 0; i<M; i++){
        cin >> a >> b >> c;
        city.push_back({a,{b,c}});
    }

    bool isNegativeCycle = bellmanFord(1);
    if(isNegativeCycle){
        cout << "-1";
        return 0;
    }
    for(int i = 2; i<= N; i++){
        if(dist[i] == MAX){
            cout << "-1\n";
        }
        else{
            cout << dist[i] << "\n";
        }
    }
    return 0;
}
#include <iostream>
#include <queue>
#include <climits>
#include <vector>
#include <algorithm>

//플로이드 방식과 다익스트라 방식 모두로 풀어보기
using namespace std;

#define INF INT_MAX

int A, B, N;
vector<vector<int>> v;
vector<vector<int>> dist;
void floyd_warshall(){
    for(int k = 0; k<N; k++)
        for(int i = 0; i<N; i++)
            for(int j = 0; j<N; j++){
                if (dist[i][k] != INF && dist[k][j] != INF)
                    dist[i][j] = min(dist[i][j], dist[i][k]+dist[k][j]) == INF ? 0 : 1;
            }
                
}

void initDist(){
    for(int i = 0; i<N; i++){
        for(int j = 0; j<N; j++){
            //if(i == j) dist[i][j] = 0;
            if(v[i][j]) dist[i][j] = v[i][j];
            else dist[i][j] = INF;
        }
    }
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> N;
    v.resize(N, vector<int>(N,0));
    dist.resize(N, vector<int>(N, 0));
    for(int i = 0; i<N; i++){
        for(int j = 0; j<N; j++){
            cin >> v[i][j];
        }
    }
    initDist();
    floyd_warshall();
    for(auto& a1: dist){
        for(auto& a2 : a1){
            if(a2 == INF) cout << 0 << ' ';
            else cout << a2 << ' ';
        }
        cout<<'\n';
    }

    return 0;
}
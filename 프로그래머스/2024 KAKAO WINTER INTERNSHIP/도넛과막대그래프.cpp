#include <string>
#include <vector>
#include <set>
#include <stack>
#include <iostream>

using namespace std;

//간선이 하나면 도넛, 막대 그래프
//간선의 끝이 자기 자신을 가리키면 도넛 그래프
//끝이 비어있으면 막대 그래프
//2개면 8자모양 그래프

vector<int> solution(vector<vector<int>> edges) {
    vector<int> answer(4,0);
    int verticesNum = 0;
    for(const auto& edge : edges){
        verticesNum = max(verticesNum, max(edge[0], edge[1]));
    }
    vector<pair<int,int>> nodeIO(verticesNum+1, {0,0}); //in out
    for(int i = 0; i<edges.size(); i++){
        nodeIO[edges[i][0]].second += 1;
        nodeIO[edges[i][1]].first += 1;
    }

    for(int i = 1; i<nodeIO.size(); i++){
        if(nodeIO[i].second == 0) answer[2] +=1;
        else if(nodeIO[i].second == 1) continue;
        else if(nodeIO[i].second == 2){
            if(nodeIO[i].first >0) answer[3] +=1;
            else answer[0] = i;
        }
        else answer[0] = i;
    }
    answer[1] = nodeIO[answer[0]].second - answer[2] - answer[3];
    return answer;
}

int main(){
    //vector<vector<int>> edges = {{2,3},{4,3},{1,1},{2,1}};
    vector<vector<int>> edges = {{4,11}, {1,12},{8,3},{12,7},{4,2},{7,11},{4,8},{9,6},{10,11},{6,10},{3,5},{11,1},{5,3},{11,9},{3,8}};
    vector<int> ans = solution(edges);
    for(auto a : ans) cout << a <<" ";
    return 0;
}
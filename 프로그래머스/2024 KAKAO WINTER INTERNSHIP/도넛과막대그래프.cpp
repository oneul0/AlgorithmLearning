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

void nodeOrder(set<int>& nodeSet, vector<vector<int>> edges){
    for(auto line : edges)
        for(auto node : line)
            nodeSet.insert(node);
}

void fillGraph(vector<vector<int>>& graph,vector<bool>& visited, vector<vector<int>> edges){
    for(int i = 0; i<edges.size(); i++){
        graph[edges[i][0]].push_back(edges[i][1]);
        visited[edges[i][0]] = false;
    }
        
}


void dfs(vector<vector<int>> graph, int pos, vector<bool>& visited, vector<int>& answer){
    stack<int> st;
    st.push(pos);
    int lastVisitedNode = 0;
    while(!st.empty()){
        int cur = st.top();
        st.pop();
        lastVisitedNode = cur;
        for(int n : graph[cur]){
            if(!visited[n]){
                visited[n] = true;
                st.push(n);
            }
        }
    }
    visited[pos] = false;
    //판단
    //간선의 수가 한개인가 두개인가
    if(graph[pos].size() == 1){
        //1. 간선의 끝이 자기 자신을 가리킬 때
        if(pos == lastVisitedNode) answer[1]+=1;
        //2. 간선의 노드가 가리키는 노드가 없을 때
        else answer[2]+=1;
    }
    else if(graph[pos].size() == 2){
        answer[3]+=1;
    }
    
}

vector<int> solution(vector<vector<int>> edges) {
    vector<int> answer(4,0);
    int startNode = 0;
    //중복없이 노드 추출 위한 set
    set<int> nodeSet;
    nodeOrder(nodeSet, edges);
    //그래프
    int lastNode = *nodeSet.rbegin();
    vector<vector<int>> graph(lastNode+1);
    vector<bool> visited(lastNode+1,true);
    fillGraph(graph,visited, edges);
    for(int i = 1; i<=graph.size(); i++){
        if(!visited[i]){
            if(graph[i].size() > 2) startNode = i; // 이거 아님 시작노드 어케구하지
        }
    }
    answer[0] = startNode;
    for(auto node : graph[startNode]){
        dfs(graph, node, visited,answer);
    }
    
    return answer;
}

int main(){
    //vector<vector<int>> edges = {{2,3},{4,3},{1,1},{2,1}};
    vector<vector<int>> edges = {{4,11}, {1,12},{8,3},{12,7},{4,2},{7,11},{4,8},{9,6},{10,11},{6,10},{3,5},{11,1},{5,3},{11,9},{3,8}};
    vector<int> ans = solution(edges);
    for(auto a : ans) cout << a <<" ";
    return 0;
}
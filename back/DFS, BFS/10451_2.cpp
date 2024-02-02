#include<iostream>
#include<vector>
#include<queue>

using namespace std;



vector<vector<int>> testcases;
vector<int> cycles;
bool visited[1001];
int t,n;

int bfs(vector<int> testcase,int si,int cnt){
    //if(visited[sx]){return cnt;}
    queue<int> q;
    q.push(si);
    visited[si] = true;
    bool check =false;
    while(!q.empty()){
        int di = q.front();
        q.pop();
        for(int i = 1; i<testcase.size()+1; i++){
            if(!visited[i]){
                check = true;
                q.push(testcase[i]);
                visited[testcase[i]] = true;
            }
        }
        
    }
    if(check){
        cnt++;
        return cnt;
    }
    return cnt;
    
}

int main(){
    
    cin >> t;
    //vector<vector<int>> testcases(t, vector<int>(n,0));
    for(int i = 0; i<t; i++){
        n = 0;
        cin >> n;
        vector<int> temp(n+1,0);
        for(int j = 1; j<n+1; j++){
            int test;
            cin >> test;
            temp[j] = test;
            
        }
        testcases.push_back(temp);
    }
    
    for(int k = 0; k<t; k++){
        int cnt;
        for(int i = 1; i<testcases[t].size()+1; i++){
            //int test = testcases[k][i];
            cnt = bfs(testcases[k], i, cnt);
        }
        cycles.push_back(cnt);
    }

    for(auto& c : cycles){
        cout << c << "\n";
    }

    return 0;
}
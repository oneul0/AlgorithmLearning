//출처 : https://miiinnn23.tistory.com/88
#include <iostream>
#include <vector>
#include <cstring>
#define MAX 10001

using namespace std;

int maximum, cnt;

//vector<vector<int>> com;
// vector<int> counts;
// vector<int> visited;

vector<int> com[MAX];
int counts[MAX];
bool visited[MAX];


void dfs(int num, int s);

int main(){
    
    int n,m;
    cin >> n >> m;

    // com.resize(n+1, vector<int>(n+1, 0));
    // counts.resize(n+1, 0);
    // visited.resize(n+1,0);

    for(int i = 0; i<m; i++){
        int n1, n2;
        cin >> n1 >> n2;

        com[n2].push_back(n1);
    }

    for(int i = 1; i<=n; i++){
        memset(visited, false, n+1*sizeof(bool));
        cnt = 0;
        dfs(i, i);
        maximum = (counts[i] > maximum ? counts[i] : maximum);
    }

    for(int i = 1; i <= n; i++){
        if(counts[i] == maximum) cout << i << ' ';
    }
    return 0;
}

void dfs(int num, int s){
    visited[num] = true;
    int len = com[num].size();

    for(int i = 0; i< len; i++){
        int nxt = com[num][i];

        if(!visited[nxt]){
            cnt++;
            dfs(nxt, s);
        }
    }
    counts[s] = (counts[s] > cnt ? counts[s] : cnt);
}


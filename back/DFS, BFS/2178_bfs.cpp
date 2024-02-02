#include<iostream>
#include<vector>
#include<queue>
#include<string>
#include<algorithm>

using namespace std;
vector<vector<int>> map;
void bfs(int pos){

}

int main(){
    int n,m;
    cin >> n >> m;

    vector<string> temp;
    for(int i = 1; i<=n; i++){
        string line;
        cin >> line;
        temp.push_back(line);
    }

    for(int i = 1; i<=n; i++){
        for(int j = 1; i<=m; j++){
            map[i][j] = temp[i][j] - '0';
        }
    }

    //bfs();

    return 0;
}
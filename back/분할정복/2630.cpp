#include <iostream>
#include <vector>

using namespace std;

int n;
bool chk = false;
vector<vector<int>> paper;
int main(){
    cin >> n;
    paper.resize(n,vector<int>(n,0));
    for(int i = 0; i<n; i++){
        for(int j = 0; j<n; j++){
            cin >> paper[i][j];
        }
    }
    if(chk){

    }

    return 0;
}
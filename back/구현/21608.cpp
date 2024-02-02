#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>


using namespace std;

int N;
vector<vector<int>> seats;
vector<vector<int>> chk;
int dx[3] = {-1,0,1}; //방향
int dy[3] = {1,0,-1};

//가중치가 있는 벡터?

void bfs(){
    queue<int> q;
    
}

int main(){

    cin >> N;
    seats.resize(N, vector<int>(N,0));
    chk.resize(N, vector<int>(N,0));
    int n = N*N;

    cin >> seats[1][1];
    for(int i = 0; i<n; i++){

    }


    return 0;
}
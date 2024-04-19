#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstring>
#include <vector>
#include <algorithm>
#include <queue>
#include <cmath>
#include <cstdio>
#include <string>
#include <deque>
#include <stack>
#define P pair<int,int>
#define PP pair<P,int>
#define LL long long

using namespace std;

char map[101][101];
int check[101][101][4];
int raser[101][101][4];
int dx[4] = {1,0,-1,0};
int dy[4] = {0,1,0,-1};
int W, H;
P start, finish;

void bfs(P X){
	queue<PP> q; // 좌표 , 방향
	q.push({X, -1});
	for(int i = 0; i < 4; i++){
		check[X.first][X.second][i] = 1;
		raser[X.first][X.second][i] = 0;
	}
	while(!q.empty()){
		int x = q.front().first.first;
		int y = q.front().first.second;
		int dir = q.front().second;
		q.pop();
		for(int i = 0; i < 4; i++){
			int xx = x + dx[i];
			int yy = y + dy[i];
			if(xx >= 1 && xx <= H && yy >= 1 && yy <= W){
				if(map[xx][yy] == '*') continue;
				if(dir == i){
					if(check[xx][yy][i] == 0){
						raser[xx][yy][i] = raser[x][y][dir];
						check[xx][yy][i] = 1;
						q.push({{xx,yy}, i});
					}
					else{
						if(raser[xx][yy][i] > raser[x][y][dir]){
							raser[xx][yy][i] = raser[x][y][dir];
							q.push({{xx,yy},i});
						}
					}
				}
				else{
					if(check[xx][yy][i] == 0){
						raser[xx][yy][i] = raser[x][y][dir] + 1;
						check[xx][yy][i] = 1;
						q.push({{xx,yy}, i});
					}
					else{
						if(raser[xx][yy][i] > raser[x][y][dir] + 1){
							raser[xx][yy][i] = raser[x][y][dir] + 1;
							q.push({{xx,yy},i});
						}
					}
				}	
			}
		}
	}
}

void solve(){
	bfs(start);
	int mini = 100000001;
	for(int i = 0; i < 4; i++){
		if(check[finish.first][finish.second][i] == 0) continue;
		mini = min(mini, raser[finish.first][finish.second][i]);
	}
	cout << mini-1;
}

int main() {
	cin.tie(0);
	cout.tie(0);
	cin >> W >> H;
	for(int i= 1; i <= H; i++){
		for(int j = 1; j <= W; j++){
			cin >> map[i][j];
			if(map[i][j] == 'C' && start.first == 0) start = {i,j};
			else if(map[i][j] == 'C') finish = {i,j};
		}
	}
	solve();
	return 0;
}
#include<iostream>
#include <vector>
#include <queue>
#include <climits>
#include <string>

using namespace std;
const int INF = 987654321;
//다익스트라 아니면 bfs
int n;
int dir[4][2] = {{1,0}, {-1,0}, {0,1}, {0,-1}};

struct coord
{
    int distance, x, y;
};

bool operator<(coord a, coord b){
	return a.distance < b.distance;
}


int solution(vector<vector<int>>& map){
	vector<vector<int>> dist(n, vector<int>(n, INF));
	vector<vector<bool>> chk(n, vector<bool>(n, false));
	queue<pair<int,int>> q;
	dist[0][0] = 0;
	chk[0][0] = true;
	q.push({0,0});
	while(!q.empty()){
		int cx = q.front().first;
		int cy = q.front().second;
		q.pop();
		
		for(int i = 0; i<4; i++){
			int nx = cx + dir[i][0];
			int ny = cy + dir[i][1];
			if(nx>=0 && nx<n && ny >= 0 && ny<n){
				if(!chk[nx][ny] || dist[nx][ny] > dist[cx][cy]+map[nx][ny]){
					chk[nx][ny] = true;
					dist[nx][ny] = dist[cx][cy]+map[nx][ny];
					q.push({nx,ny});
				}
			}
		}
	}

	return dist[n-1][n-1];
}

int main(int argc, char** argv)
{
	ios_base::sync_with_stdio(false); cin.tie(nullptr);
	int test_case;
	int T;
	
	cin>>T;
	
	for(test_case = 1; test_case <= T; ++test_case)
	{
        cin >> n;
        vector<vector<int>> map(n);
		string s;
		for(int i = 0; i<n; i++){
			cin >> s;
			for(char& c: s)
				map[i].push_back(c-'0');
		}
		cout << "#" << test_case<<" "<< solution(map)<<'\n';

	}
	return 0;
}
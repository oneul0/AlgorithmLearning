#include<iostream>
#include <vector>

using namespace std;
int T,n;
//y+1, x-1, y-1, x+1
int direct[4][2] = {{0,1}, {1,0}, {0,-1}, {-1,0}};
vector<vector<int>> solution(int n){
	vector<vector<int>> ans(n, vector<int>(n,0));
	int cnt =1, flag = n*n-1;
	ans[0][0] = 1;
	int cx = 0, cy=0;
	int dir = 0;
	while(flag--){
		cnt++;
		//다음 블록 체크
		int nx = cx+direct[dir][0];
		int ny = cy+direct[dir][1];
		//방향을 바꿔야 하는가?
		if(nx >= n || ny >= n || nx < 0 || ny < 0 || ans[nx][ny] != 0){
			if(dir >= 3) dir = 0;
			else dir++;
			nx = cx+direct[dir][0];
			ny = cy+direct[dir][1];
		}
		cx = nx;
		cy = ny;
		ans[cx][cy] = cnt;
	}
	 
	return ans;
}

int main(int argc, char** argv)
{
	ios_base::sync_with_stdio(false); cin.tie(nullptr);
	int test_case;
	
	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{
		cin >> n;
		cout <<"#"<<test_case<<'\n';
		vector<vector<int>> v = solution(n);
		for(int i=0; i<n; i++){
			for(int j = 0; j<n; j++){
				cout << v[i][j] << " ";
			}
			cout << '\n';
		}
	}
	return 0;
}
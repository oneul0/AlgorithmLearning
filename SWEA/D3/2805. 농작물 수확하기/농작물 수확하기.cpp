#include<iostream>
#include <vector>
#include <queue>
using namespace std;

int d[4][2] = {{-1,0}, {1,0}, {0,-1}, {0,1}};

int bfs(int n, const vector<vector<int>>& v){
    int ans = 0;
    queue<pair<int,pair<int,int>>> q;
    vector<vector<bool>> chk(n,vector<bool>(n,false));
    int sx = n/2;
    int sy = n/2;
    ans += v[sx][sy];
    chk[sx][sy] = true;
    int cnt = 0;
    q.push({cnt,{sx,sy}});
    
    while(!q.empty()){
        int ccnt = q.front().first;
        int cx = q.front().second.first;
        int cy = q.front().second.second;
        q.pop();
        for(int i = 0; i<4; i++){
            int nx = cx + d[i][0];
            int ny = cy + d[i][1];
            if(nx>=0 && nx<n && ny >= 0 && ny < n && !chk[nx][ny] && ccnt<n/2){
                ans += v[nx][ny];
                chk[nx][ny] = true;
                q.push({ccnt+1,{nx,ny}});
            }
        }
    }

    return ans;
}


int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
	int test_case;
	int T,n;
	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{
        string s;
        cin >> n;
        vector<vector<int>> v(n);
        for(int i = 0; i<n; i++){
            cin >> s;
            for(char& c : s){
                v[i].push_back(c-'0');
            }

        }
        cout << '#' << test_case<< " " << bfs(n, v)<<'\n';
	}
	return 0;
}
#include <iostream>
#include <vector>
#include <queue>
using namespace std;
vector<vector<int>> v(100, vector<int>(100,0));
vector<vector<bool>> chk(100,vector<bool>(100,false));
pair<int,int> sx;
int dr[4][2] = {{0,1}, {0,-1}, {-1,0}, {1,0}};

bool isPossible(int nx, int ny){
    if(nx>=0 && nx<16 && ny>=0 && ny<16 && !chk[nx][ny] && (v[nx][ny]==0 || v[nx][ny]==3)) return true;
    return false;
}

//도착지점에서 시작
int bfs(int sx, int sy){
    int cx,cy, flag = 0;
    queue<pair<int,int>> q;
    q.push({sx,sy});
    chk[sx][sy] = true;

    while(!q.empty()){
        int cx = q.front().first;
        int cy = q.front().second;
        if(v[cx][cy] == 3){
            flag = 1;
            break;
        }
        q.pop();

        for(int i = 0; i<4; i++){
            int nx = cx+dr[i][0];
            int ny = cy+dr[i][1];
            if(isPossible(nx,ny)){
                q.push({nx,ny});
                chk[nx][ny] = true;
            }
        }
    }
    return flag;
}

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
	int test_case;
	int T;
	for(test_case = 1; test_case <= 10; ++test_case)
	{
        v.assign(16, vector<int>(16,0));
        chk.assign(16,vector<bool>(16,false));
        cin>>T;
        for(int i = 0; i<16; i++){
            string s;
            cin >> s;
            for(int j = 0; j<16; j++){
                v[i][j] = s[j]-'0';
                if(v[i][j] == 2){
                    sx = {i,j};
                }
            }
        }
        
        int ans = bfs(sx.first, sx.second);
    
        cout << '#' << T <<' '<< ans <<'\n';
	}
    
	return 0;
}

#include <iostream>
#include <vector>
#include <queue>
using namespace std;
vector<vector<int>> v(100, vector<int>(100,0));
vector<vector<bool>> chk(100,vector<bool>(100,false));
pair<int,int> sx;
int dr[3][2] = {{0,1}, {0,-1}, {-1,0}};

//도착지점에서 시작
int search(int sx, int sy){
    int gy = -1, cx, cy;
    queue<pair<int,int>> q;
    q.push({sx,sy});
    chk[sx][sy] = true;
    while(!q.empty()){
        cx = q.front().first;
        cy = q.front().second;
        if(cx == 0) break;
        q.pop();
        for(int d= 0; d<3; d++){
            int nx = cx + dr[d][0];
            int ny = cy + dr[d][1];
            if(v[nx][ny] != 1 || ny<0 || ny>=100 || nx<0 || nx>=100 || chk[nx][ny]) continue;
            if(q.empty()){
                q.push({nx,ny});
                chk[nx][ny]= true;
            }
        }
    }
    gy = cy;
    return gy;
}

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
	int test_case;
	int T;
	for(test_case = 1; test_case <= 10; ++test_case)
	{
        v.assign(100, vector<int>(100,0));
        chk.assign(100,vector<bool>(100,false));
        cin>>T;
        for(int i = 0; i<100; i++){
            for(int j = 0; j<100; j++){
                cin >> v[i][j];
                if(i == 99 && v[i][j] == 2){
                    sx = {i,j};
                }
            }
        }
        
        int ans = search(sx.first, sx.second);
    
        cout << '#' << T <<' '<< ans <<'\n';
	}
    
	return 0;
}

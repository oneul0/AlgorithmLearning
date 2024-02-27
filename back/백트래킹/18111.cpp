#include <iostream>
#include <vector>
const int MAX = INT32_MAX;
using namespace std;

int N, M, B, usingTime = MAX, maxHeight = 0, minHeight = 300, height = 0;
vector<vector<int>> map;
//몇 층으로 맞춰야 최소시간인지?
void flattening(int blockHeight){
    int build = 0, dig = 0,spendTime;
    for(int x = 0; x<N; x++){
        for(int y = 0; y<M; y++){
            if(map[x][y] != blockHeight){
                int tmp = map[x][y] - blockHeight;
                //캐기
                if(tmp > 0) dig += tmp;
                //쌓기
                else if(tmp < 0) build -= tmp;
            }
            
        }
    }
    if(dig+B >= build){
        spendTime = dig*2+build;
        if(usingTime >= spendTime){
            usingTime = spendTime;
            height = max(height, blockHeight);
        }
    }
    return;
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    cin >> N >> M >> B;
    map.resize(N, vector<int>(M,0));
    for(int i = 0; i<N; i++){
        for(int j = 0; j<M; j++){
            cin >> map[i][j];
            maxHeight = max(map[i][j], maxHeight);
            minHeight = min(map[i][j], minHeight);
        }
    }
    // minHeight부터 maxHeight 까지 모두 검사
    for(int h = minHeight; h<=maxHeight; h++){
        flattening(h);
    }
    
    cout << usingTime << " " << height;
    
    return 0;
}
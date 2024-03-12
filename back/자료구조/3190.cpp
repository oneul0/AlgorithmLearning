#include <iostream>
#include <vector>
#include <deque>

using namespace std;

int N, K, L, X,playTime = 0, flag = 0;
char C;
//apple location info vector
int appleLoc[100][100];
vector<pair<int,char>> snakeVec;
deque<pair<int,int>> snake;

pair<int,int> nxtDirection;
void dummyGame(int goTime, char rotDirection){
    for(int j = 0; j<goTime; j++){
        //머리 늘리기
        //현재 좌표
        int cx = snake.front().first;
        int cy = snake.front().second;
        snake.pop_front();
        //다음 좌표
        int nx = cx + nxtDirection.first;
        int ny = cy + nxtDirection.second;
cout << "nx : "<<nx <<" ny : "<<ny<<endl;
        //if(몸과 벽이 부딪힌다면 게임 종료 flag 반환)
        if(nx>=N || ny >=N || nx<0 || ny <0){ //벽과 부딪히면
            flag = -1;
            return;
        }
        //안 부딪히면 snake에 push head location info
        snake.push_front({nx,ny}); //머리 추가
        snake.push_back({cx,cy}); //꼬리
        //사과 chk -> true:꼬리 회수x
        if(appleLoc[nx][ny] == 1){//사과가 있으면
            appleLoc[nx][ny] = 0;
        }
        //false : 꼬리 회수
        else if(appleLoc[nx][ny] != 1){
            snake.pop_back();
        }
        
    }//직진 끝
    int nxd = nxtDirection.first;
    int nyd = nxtDirection.second;
    if(rotDirection == 'L'){//왼쪽으로 90도
        if(!nxd){
            nyd = 0;
            if(nyd>0) nxd = -1;
            else nxd = 1;
        }
        else if(!nyd){
            nxd = 0;
            if(nxd > 0) nyd = 1;
            else nyd = -1;
        }
    }
    else if(rotDirection == 'D'){//오른쪽으로 90도
        if(!nxd){
            nyd = 0;
            if(nyd>0) nxd = 1;
            else nxd = -1;
        }
        else if(!nyd){
            nxd = 0;
            if(nxd > 0) nyd = -1;
            else nyd = 1;
        }
    }
    nxtDirection.first = nxd;
    nxtDirection.second = nyd;
}

int main(){
    cin >> N;
    cin >> K;
    
    for(int i = 0; i<K; i++){
        int a, b;
        cin >> a >> b;
        appleLoc[a][b] = 1; //사과 위치 == 1
    }
    cin >> L;
    snake.push_back(make_pair(0,0));
    nxtDirection = {1,0}; 
    for(int i = 0; i<L; i++){
        cin >> X >> C;
        snakeVec.push_back({X,C});
    }

    for(auto& a:snakeVec){
        dummyGame(a.first,a.second);
        if(flag == -1){
            cout <<playTime;
            return 0;
        }
    }
    cout <<playTime;
    return 0;
}
#include<iostream>
#include<vector>

using namespace std;
int paper[100][100] = {{0}};

int n;
int cnt = 0;
void fill_paper(int x, int y){
    int sx = x;
    int sy = y;
    int dx = x+9;
    int dy = y+9;

    for(int i = sx; i<=dx; i++){
        for(int j = sy; j<= dy; j++){
            if(!paper[i][j]){
                paper[i][j] = 1;
                cnt++;
            }
        }
        
    }
}

int main(){
    
    cin >> n;

    for(int i = 0; i<n; i++){
        int x,y;
        cin >> x >> y;
        fill_paper(x,y);
    }

    cout << cnt;
    return 0;
}
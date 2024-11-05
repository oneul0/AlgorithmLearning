#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int num, ans=0;
//1~10번째 줄어드는 수 -> 0~9
int ROW = 1<<16, COL = 1<<16;
int LDIAGONAL = 1<<30, RDIAGONAL = 1<<30;

void backtracking(int depth, int row){
    if(depth == num){
        ans++;
        return;
    }

    for(int i = 0; i < num; i++){
        if((ROW & (1<<i)) || (LDIAGONAL & (1<<(i + row))) || (RDIAGONAL & (1<<(row - i + num - 1)))) continue;
        ROW |= (1<<i);
        LDIAGONAL |= (1<<(i + row));
        RDIAGONAL |= (1<<(row - i + num - 1));
        backtracking(depth + 1, row + 1);
        ROW &= ~(1<<i);
        LDIAGONAL &= ~(1<<(i + row));
        RDIAGONAL &= ~(1<<(row - i + num - 1));
    }

}


int main(){
    ios_base::sync_with_stdio(false); cin.tie(0);
    cin >> num;
    backtracking(0,0);
    cout << ans;
    return 0;
}
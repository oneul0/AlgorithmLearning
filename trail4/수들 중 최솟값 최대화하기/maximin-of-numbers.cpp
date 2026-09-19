#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n, maxVal = 0;
int grid[10][10];
void permute(int x, int y, int val, int mask){
    if(x == n){
        maxVal = max(maxVal, val);
        return;
    }
    for(int j = 0; j<n; j++){
        if((mask & (1<<j)) != 0) continue;
        permute(x+1, j, min(val, grid[x][j]), mask | (1<<j));
    }
}

int main() {
    cin >> n;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> grid[i][j];
        }
    }

    permute(0, 0, 987654321, 0);
    cout << maxVal;

    return 0;
}

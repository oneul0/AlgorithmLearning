#include<iostream>
#include <string>
#include <cmath>
#include <memory.h>
using namespace std;

int n;
int board[10];
int cnt = 0;
bool isPromise(int cdx){
    for(int i = 0; i<cdx; i++){
        if(board[cdx] == board[i] || cdx - i == abs(board[cdx] - board[i])){
            return false;
        }
    }
    return true;
}
void backTraking(int cdx){
    if(cdx == n){
        cnt++;
        return;
    }
    for(int i = 0; i<n; i++){
        board[cdx] = i;
        if(isPromise(cdx)) backTraking(cdx+1);
    }
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
        backTraking(0);
        cout << '#' << test_case << " " << cnt << '\n';
        cnt = n = 0;

        memset(board, 0, sizeof(board));
	}

    return 0;
}
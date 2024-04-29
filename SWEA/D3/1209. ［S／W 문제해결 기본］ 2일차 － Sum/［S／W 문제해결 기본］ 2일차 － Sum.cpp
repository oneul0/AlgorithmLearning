#include<iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);
     cin.tie(nullptr);
	int test_case;
	int T;
	
	for(test_case = 1; test_case <= 10; ++test_case)
	{
        vector<vector<int>> v(100, vector<int>(100,0));
        int maxSum = 0;
        cin>>T;
        for(int i = 0; i<100; i++){
            int total = 0;
            for(int j = 0; j<100; j++){
                cin >> v[i][j];
                total += v[i][j];
            }
            maxSum = max(maxSum, total); //각 행 중 최대값
        }

        for(int i = 0; i<100; i++){
            int total = 0;
            for(int j = 0; j<100; j++){
                total += v[j][i];
            }
            maxSum = max(maxSum, total); //각 열 중 최대값
        }
        int total = 0, rtotal = 0;
        for(int i = 0; i<100; i++){
            total += v[i][i];
            rtotal += v[99-i][99-i];
        }
        maxSum = max({maxSum, total, rtotal}); //대각선 중 최대값

        cout << '#' << T << " "<< maxSum <<'\n';
	}
	return 0;
}
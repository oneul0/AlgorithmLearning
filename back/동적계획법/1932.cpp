#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
//대각선 왼쪽 또는 오른쪽
// -> i, i+1인 수
vector<vector<int>> v;
vector<vector<int>> t;

int main(){
    cin >> n;
    for(int i = 0; i<n; i++){
        vector<int> tmp;
        for(int j = 0; j<=i; j++){
            int num;
            cin >> num;
            tmp.push_back(num);
        }
        v.push_back(tmp);
    }
    //i-1단계에서 선택할 수 있는 가장 큰 수
    // -> j, j-1
    //반대로?
    t.resize(n);
    t[0].push_back(v[0][0]);

    for(int i = 1; i<n; i++){
        for(int j = 0; j<=i; j++){
            if(i<j) continue;

            int tmp;
            if(j-1 < 0)
                tmp = t[i-1][j]+v[i][j];
            else if(i==j)
                tmp = t[i-1][j-1]+v[i][j];
            else
                tmp = max(t[i-1][j]+v[i][j], t[i-1][j-1]+v[i][j]);

            t[i].push_back(tmp);
        }
    }
    cout << *max_element(t[n-1].begin(), t[n-1].end());
    return 0;
}
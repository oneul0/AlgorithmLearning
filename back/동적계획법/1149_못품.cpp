#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<vector<int>> house;
int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int n;
    
    house.resize(n,vector<int>(3,0));
    cin >> n;
    for(int i = 1; i <= n; i++){
        vector<int> cost(3,0);
        cin >> cost[0] >> cost[1] >> cost[2];
        house[i][0] = min(house[i-1][1], house[i-1][2])+cost[0];
        house[i][1] = min(house[i-1][0], house[i-1][2])+cost[1];
        house[i][2] = min(house[i-1][1], house[i-1][0])+cost[2];
        
    }
    int ans = *min_element(house[n].begin(), house[n].end());
    cout << ans;
    return 0;
}

//https://cryptosalamander.tistory.com/84
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main(){
    int n, k, s;

    cin >> n >> k;
    vector<int> sensors;
    vector<int> dist;
    while(n--){
        cin >>s;
        sensors.push_back(s);
    }
// 1 3 6 6 7 9
    sort(sensors.begin(), sensors.end());
    
    for(int i = 0; i<sensors.size()-k; i++){
        int sum = 0;
        int pos = sensors[i];
        
        for(int j = i+1; j<=i+k; j+=k){
            sum += (sensors[j]-pos);
            cout<<"sensors[j] : "<< sensors[j] <<" sum : "<< sum<< " j : "<<j << endl;
        }
        dist.push_back(sum);
    }
    sort(dist.begin(), dist.end());

    int ans = 0;
    for(int i = 0; i<k; i++){
        ans += dist[i];
    }
    
    cout << ans;
    return 0;
}
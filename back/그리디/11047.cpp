#include <iostream>
#include <vector>

using namespace std;

int main(){
    int k, n;
    int cnt = 0;
    cin >> n >> k;
    vector<int> v(n, 0);
    for(int i = 0; i<n; i++){
        cin >> v[i];
    }

    for(int i = n-1; i>=0; i--){
        if(k >= v[i]){
            while(k>=v[i]){
                k -= v[i];
                cnt++;
            }
            
        }
    }

    cout << cnt;
    return 0;
}
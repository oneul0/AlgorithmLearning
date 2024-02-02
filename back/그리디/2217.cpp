#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    int n, max, cur;
    
    cin >> n;
    vector<int> v(n,0);
    for(int i =0; i<n; i++){
        cin >> v[i];
    }

    sort(v.begin(), v.end());

    max = v.back();
    
    int iter = n-1;

    while(iter--){
        cur = v[iter]*(n-iter); //n!개 만큼 요소 곱하기
        if(max < cur){ max = cur; }
    }

    cout << max;
    return 0;
}
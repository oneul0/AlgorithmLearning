#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main(){

    int n;
    cin >> n;
    vector<float> v(n,0);

    for(int i =0; i<n; i++){
        cin >> v[i];
    }

    sort(v.begin(), v.end());
    float base = v.back();
    for(int i = 0; i<n-1; i++){
        base += v[i]/2;
    }

    cout << base;
    
    return 0;
}
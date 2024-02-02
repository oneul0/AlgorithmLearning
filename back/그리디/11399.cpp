#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int n;
    int time = 0;

    cin >> n;
    vector<int> p(n, 0);
    for(int i = 0; i<n; i++){
        cin >> p[i];
    }
    sort(p.begin(), p.end());

    for(int i = 0; i<n; i++){
        for(int j = 0; j<=i; j++){
            time+=p[j];
        }

    }
    cout << time;
    return 0;
}
#include<iostream>
#include <algorithm>
#include <vector>
using namespace std;
vector<int> v;
int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int t,n,k;
    cin >> t;
    for(int i = 0; i<t; i++){
        cin >> n;
        v.resize(n,0);
        for(int j = 0; j<n; j++){
            cin >> v[j];
        }
        cout << *min_element(v.begin(), v.end()) << " "<<*max_element(v.begin(), v.end())<<"\n";
    }
    


    return 0;
}
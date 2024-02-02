#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main(){
    int n, k, s;

    cin >> n >> k;
    vector<int> v;
    vector<int> dist;
    while(n--){
        cin >>s;
        v.push_back(s);
    }

    sort(v.begin(), v.end());
    int vsize = v.back();

    

    cout << 0;
    return 0;
}
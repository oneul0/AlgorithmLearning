#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int A, N, ans;
    vector<int> v;
    cin >> N;
    for(int i = 0; i<N; i++){
        cin >> A;
        v.push_back(A);
    }
    ans = (*max_element(v.begin(), v.end()))*(*min_element(v.begin(), v.end()));
    cout << ans;
    return 0;
}
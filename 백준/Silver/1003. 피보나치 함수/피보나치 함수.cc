#include <iostream>
#include <vector>

using namespace std;

int T,N;
vector<pair<int,int>> arr(40);

int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    cin >> T;
    arr[0] = {1,0};
    arr[1] = {0,1};
    for(int i = 2; i<=40; i++){
        arr[i] = {arr[i-1].first + arr[i-2].first, arr[i-1].second + arr[i-2].second};
    }
    for(int i = 0; i<T; i++){
        cin >> N;
        cout << arr[N].first <<" " << arr[N].second <<'\n';
    }
}
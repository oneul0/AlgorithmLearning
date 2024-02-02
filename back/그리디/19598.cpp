#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#include <utility>

using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int n;
    cin >> n;
    vector<pair<int,int>> v;
    priority_queue<int, vector<int>, greater<int>> pq;

    int a,b;
    while(n--){
        cin >> a >> b;
        v.push_back(make_pair(a,b));
    }
    
    sort(v.begin(), v.end());

    pq.push(v[0].second);


    for(int i = 1; i<v.size(); i++){
        if(pq.top() <= v[i].first){
            pq.pop();
            pq.push(v[i].second);
        }
        else{
            pq.push(v[i].second);
        }
    }

    cout << pq.size();

    return 0;
}
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
#include <utility>

using namespace std;
vector<pair<int, int>> room;
priority_queue<int , vector<int>, greater<int>> pq;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int n;
    cin >> n;
    
    for(int i = 0; i<n; i++){
        int a,b;
        cin >> a >> b;
        room.push_back(make_pair(a,b));
    }

    sort(room.begin(), room.end());

    pq.push(room[0].second);

    for(int i = 1; i<n; i++){
        if(pq.top() <= room[i].first){
            pq.pop();
            pq.push(room[i].second);
        }
        else{
            pq.push(room[i].second);
        }
    }
   
    cout << pq.size();
    return 0;
}
#include <iostream>
#include <queue>

using namespace std;


priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;

int n, a, b;
int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n;
    while(n--){
        cin >> a >> b;
        pq.push({a,b});
    }

    while(!pq.empty()){
        pair<int,int> p = pq.top();
        pq.pop();
        cout << p.first << " "<< p.second<<"\n";
    }
    return 0;
}
#include <iostream>
#include <queue>

using namespace std;

int N,a;

int main(){
    priority_queue<int> pq;
    cin >> N;
    for(int i = 0; i<N; i++){
        for(int j = 0; j<N; j++){
            cin >> a;
            
            pq.emplace(a);
        }
    }

    a = N-1;
    while(a--){
        pq.pop();
    }
    cout << pq.top();
    return 0;
}
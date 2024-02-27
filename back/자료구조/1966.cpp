#include <iostream>
#include <queue>

using namespace std;
int T, n, m, p,cnt = 0;

int main(){
    ios_base::sync_with_stdio(0);cin.tie(0);
    cin >> T;
    for(int i = 0; i<T; i++){
        queue<pair<int,int>> docs;
        priority_queue<int> maxQ;
        cnt = 0;
        cin >> n >> m;
        for(int j = 0; j<n; j++){
            cin >> p;
            docs.push({j,p}); //j = 문서 번호 p = 문서 우선순위
            maxQ.push(p);
        }
        while(!docs.empty()){
            pair<int,int> t = docs.front();
            int maxI = maxQ.top();
            docs.pop();
            
            //cout << "docs num : "<< t.first << " cnt : "<< cnt <<" ";
            if(t.second == maxI){
                cnt++;
                if(t.first == m){
                    cout << cnt <<"\n";
                    break;
                }
                

                maxQ.pop();
            }
            else{
                docs.push(t);
            }
            
        }
    }

    return 0;
}
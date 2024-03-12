#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n;
vector<long long> result;
// 0~9의 숫자를 이용하여 수의 조합을 찾음
void DFS(long long idx, int cnt){
    if(cnt>10)
        return;
    result.push_back(idx);
    for(int i=0; i<10; i++){
        if(idx%10>i){
            DFS(idx*10+i, cnt+1);
        }
    }
    return;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin>>n;
    result.push_back(0);
    for(int i=0; i<10; i++){
        DFS(i, 1);
    }
    sort(result.begin(), result.end());
    if(result.size()<=n){
        cout<<"-1"<<endl;
    }
    else if(result.size()>n) {
        cout<<result[n]<<endl;
    }
    return 0;
}
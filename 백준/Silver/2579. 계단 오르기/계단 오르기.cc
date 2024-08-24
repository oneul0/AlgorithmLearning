#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int n;
vector<int> v;
vector<int> s;

int main(){
    cin >> n;
    v.resize(n,0);
    s.resize(n,0);
    for(int i =0; i<n; i++){
        cin >> v[i];
    }
    //n-1까지 비교 n번째는 항상 밟기 때문
    //한 계단 혹은 두 계단씩 오를 수 있음
    //i위치까지의 최대값을 구해야함
    
    //초기화
    s[0] = v[0];
    s[1] = v[0]+v[1];
    s[2] = v[2]+max(v[0], v[1]);
    for(int i = 3; i<n; i++){
        s[i] = max(s[i-2], s[i-3]+v[i-1]) +v[i];
        //퐁당퐁당과 이전의 2개의 합 중 큰 수를 선택
    }
    cout << s[n-1];
    return 0;
}
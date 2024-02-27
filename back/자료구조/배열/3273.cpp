#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int n, x, cnt = 0, left_num, right_num, y=0;
vector<int> v;
int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    cin >> n;
    v.resize(n);
    for(int i = 0; i<n; i++){
        cin >> v[i];
    }
    cin >> x;
    sort(v.begin(), v.end());
    left_num = 0;
    right_num = n-1;
    while(1){
        y = v[left_num]+v[right_num];
        if(y < x){
            left_num++;
        }
        else if(y>x){
            right_num--;
        }
        else if(y==x){
            cnt++;
            right_num--;
        }
        if(left_num>=right_num) break;
    }
    //1 2 3 5 7 9 10 11 12
    //양쪽에서 가운데로 수렴하는 투포인터
    
    cout << cnt;

    return 0;
}
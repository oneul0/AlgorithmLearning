#include <iostream>
#include <vector>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int n;
    cin >> n;
    int ans = 1;
    bool chk = (n==1) ? false : true;
    int cnt = 0;
    int min = 2;
    int max = 7;
    while(chk){
        cnt++;
        if(n>=min && n<=max){
            break;
        }
        min += 6*cnt;
        max += 6*(cnt+1);

    }
 
    cout << ans+cnt;
    return 0;
}
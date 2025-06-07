#include <iostream>
#include <cmath>

using namespace std;

int main(){
    int s, e, p=0, m = INT32_MAX;
    cin >> s >> e;
    for(int i = s; i<=e; i++){
        int tmp = sqrt(i);
        if(tmp * tmp == i){
            m = min(m, i);
            p += i;
        }
    }
    if(p == 0){
        cout << -1;
        return 0;
    }
    cout << p << endl << m;
    return 0;
}
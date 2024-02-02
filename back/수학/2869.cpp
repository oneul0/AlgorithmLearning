#include <iostream>
using namespace std;
int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int a,b,v;
    cin >> a >> b >> v;
    int num = (v-a)/(a-b);
    int day = (v-a)%(a-b)==0 ? num+1 : num+2;
    cout << day;
    return 0;
}

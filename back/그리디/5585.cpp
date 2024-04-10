#include <iostream>

using namespace std;
int change = 1000;
int m[6] = {500,100,50,10,5,1};
int main(){
    int n;
    cin >> n;
    change -= n;
    int i = 0, cnt = 0;
    while(change!=0) {
        if(change < m[i]) i++;
        if(change >= m[i]){
            change -= m[i];
            cnt++;
        }
    }
    cout << cnt;
}
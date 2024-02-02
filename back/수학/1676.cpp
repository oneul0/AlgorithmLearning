#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

vector<int> num;
int inputNum;

void factor(int a){
    int div = 2;
    while(a>1){
        if(a%div == 0){
            num[div]++;
            a /= div;
        }
        else{
            div++;
        }
    }
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    //분해해서 10이 몇 쌍 나오나 확인
    cin >> inputNum;
    num.resize(inputNum+1);
    for(int i = 1; i<=inputNum; i++){
        factor(i);
    }
    int minNum = min(num[2], num[5]);
    cout << minNum;
    

    return 0;
}
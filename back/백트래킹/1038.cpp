#include <iostream>
#include <vector>
#include <string>

using namespace std;

int N, cnt=0, decreaseNum = -1;

void findDecreaseNum(int num, int cnt){
    while(1){
        bool decreaseChk = true;
        if(cnt == N){
            decreaseNum = num;
            break;
        }
        // string number = to_string(num);
        // for(int i = 1; i<number.size(); i++){
        //     if(number[i-1]<=number[i]){
        //         decreaseChk = false;
        //         break;
        //     }
        // }
        //정수형으로만 관리하기
        int a=num,b,beforeNum=0;//a는 num, b는 각각의 자리수
        beforeNum = a%10;
        a /=10;
        while(a!=0){
            b = a%10;
            if(beforeNum>=b){
                decreaseChk = false;
                break;
            }
            a /=10;
            beforeNum = b;
        }

        
        if(decreaseChk) cnt++;
        num++;
    }
}
//i<i-1가 무조건 성립되어야하므로,
//number[]는 number[i-1]의 값 까지만 반복되어야한다.
int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    cin >> N;

    if(N<10){
        cout << N;
        return 0;
    }
    findDecreaseNum(0,cnt);

    cout << decreaseNum;
    return 0;
}
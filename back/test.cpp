#include <iostream>

using namespace std;

/*
나왔던 모든 숫자는 2번씩 나와야 4개의 점이 생성됨
따라서 숫자를 입력 받고 0이 아닌 수를 찾아서 출력해주면 됨
*/

int a=5;
int x1,x2;
int main(){
    cin >> x1 >> x2;
    a = a^x1^x2;
    cout << a;
    

    return 0;
}
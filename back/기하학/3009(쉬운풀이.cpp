#include <iostream>

using namespace std;

/*
나왔던 모든 숫자는 2번씩 나와야 4개의 점이 생성됨
따라서 숫자를 입력 받고 0이 아닌 수를 찾아서 출력해주면 됨
*/

int a=0,b=0;
int x,y;
int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    for(int i = 0; i<3; i++){
        cin >> x >> y;
        a = a^x;
        b = b^y;
        cout << "a: "<<a <<" b: "<<b<<endl;
    }
    cout << "답 : ";
    cout << a<< " " << b;
    

    return 0;
}
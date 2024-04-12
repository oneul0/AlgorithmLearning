#include <string>
#include <vector>
#include <iostream>
using namespace std;
const int MOD = 10007;
vector<int> a,b;
int solution(int n, vector<int> tops) {
    int answer = 0;
    a.resize(n+1,0); b.resize(n+1,0);

    //a[0] = 0;
    b[0] = 1;

    for(int i = 1; i<=n; i++){
        //k번째 뚜껑(아래 방향 정삼각형) 위에 정삼각형이 있는 경우
        if(tops[i-1]){
            a[i] = (a[i-1]+b[i-1])%MOD;
            b[i] = (2*a[i-1] + 3*b[i-1])%MOD;
        }
        //k번째 뚜껑 위에 정삼각형이 없는 경우
        else{
            a[i] = (a[i-1]+b[i-1])%MOD;
            b[i] = (a[i-1]+2*b[i-1])%MOD;
        }
    }
    
    answer = (a[n]+b[n])%MOD;
    return answer;
}

int main(){
    int n = 4;
    vector<int> tops = {1,1,0,1};
    cout << solution(n, tops);
    return 0;
}
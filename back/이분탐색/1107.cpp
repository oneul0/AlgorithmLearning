#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int m, btn, cnt = 0, tmp, cur;
vector<char> v;
string s = "100";
string n;

int main(){
    for(int i = 0; i<10; i++){
        v.push_back(i);
    }
    cin >> n >> m;
    for(int i = 0; i<m; i++){
        cin >> btn;
        v[btn] = -1;
    }
    if(n == "100"){
        cout << 0;
        return 0;
    }
    //시작 숫자 만들기
    for(char& c : n){
        if(find(v.begin(), v.end(), c)!=v.end()){
            cnt++;
        }
    }
    //버튼 몇 번 눌렸는지 알 수 있음 -> 앞에서 몇 자리까지 채워졌나
    tmp = cnt;
    cur = stoi(n);
    for(int i = 0; i<cnt; i++){
        cur /= 10;
        cout << cur << " ";
    }
    
    //+-하기
    while(cur != 0){
        cnt++;
        cur--;
    }
    cout << cnt;

    return 0;
}
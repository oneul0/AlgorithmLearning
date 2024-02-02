#include <iostream>
#include <vector>
#include <string>


using namespace std;

/*
무조건 열리는 괄호로 시작해야함
열림을 각자 구분
열림
  열림
  닫힘
닫힘
열림
  열림
    열림
      열림
      닫힘
    닫힘
  닫힘
닫힘
닫힘 -> error
*/

vector<string> v;
string isVPS(string tmp){
    string vps = "NO";
    bool isRealVps = true;
    int cnt = 0;
    //vector<char> tmp_v;
    for(char c : tmp){
        if(c=='(')  cnt++;
        else if(c==')'){
            cnt--;
            if(cnt <0){ isRealVps = false; }
        }

        //tmp_v.push_back(c);
    }
    if(cnt == 0&&isRealVps) vps = "YES";

    return vps;
}

int main(){
    ios_base::sync_with_stdio(false); cin.tie(0);
    int t;
    string tempString;
    cin >> t;
    while(t--){
        cin >> tempString;
        v.push_back(isVPS(tempString));
    }

    for(auto s : v){
        cout<<s<<'\n';
    }
    return 0;
}
#include <iostream>
#include <map>
#include <unordered_map>
#include <string>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false); cin.tie(NULL);
    int n, m;
    string s;
    unordered_map<int, string> dic_key;
    unordered_map<string, int> dic_val;
    

    cin >> n >> m;
    for(int i =1; i<=n; i++){
        cin >> s;
        dic_key.insert(make_pair(i, s));
        dic_val.insert(make_pair(s, i));
    }

    for(int i = 0; i<m; i++){
        cin >> s;
        //숫자일때
        
        if(isdigit(s[0])){
            int tmp = stoi(s);
            if(dic_key.find(tmp) != dic_key.end()){
                cout << dic_key.at(tmp) <<'\n';
            }
        }
        else{ //문자일때
            if(dic_val.find(s) != dic_val.end()){
                cout << dic_val.at(s)<<'\n';
            }
        }
    }

    return 0;
}

/*
정리

1. isdigit 이용하는거
string을 배열의 형태로 표현(ex. s[0])했을 때 char의 형태로 하나씩 \n까지 저장된다.
포켓몬의 이름은 무조건 문자의 형태기 때문에 isdigit은 0이 나옴.
따라서 처리 속도를 높힐 수 있다.

2. map 자료구조
map 자료구조는 (key, value)의 형태를 가지고 있다.
검색은 key값을 기준으로 이루어지며, value의 값으로 검색하는 방법을 이용할 경우,
요소를 전체 탐색하며 비교하기 때문에 선형 탐색이 이루어져, vector나 array 등 다른 자료구조와 차별점이 없어질 수 있다.
따라서 이 문제에서는 각각의 키 값을 가진 2개의 map을 만들어서 해결하였다.


*/
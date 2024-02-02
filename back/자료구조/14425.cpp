#include <iostream>
#include <set>
#include <algorithm>
#include <string>

using namespace std;

int n,m, cnt = 0;
string s;
set<string> words;
int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n >> m;
    while(n--){
        cin >> s;
        words.insert(s);
    }
    while(m--){
        cin >> s;
        if(words.find(s) != words.end()) cnt++;
    }
    cout << cnt;
    return 0;
}

/*
정리
1. set 자료구조
set 자료구조는 key 값으로만 이루어져있으므로, key값과 일치하는게 있는지 바로 탐색이 가능하다.
탐색 시간 복잡도는 O(logN)이다.
요소가 존재하는지 확인하는 방법은
1. find로 반환된 iterator가 set의 end요소를 가르키는지
2. count의 반환 값이 1인지 0인지로 알 수 있다.
set 자료구조는 중복값이 허용되지 않으므로, 찾고자 하는 요소의 값은 최대 1이다.
따라서 존재하면 1, 존재하지 않으면 0이므로 find 대신에 사용할 수 있다.
*/
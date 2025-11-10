#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(long long n) {
    string str = to_string(n);
    sort(str.begin(), str.end());
    string tmp = "";
    for(int i = str.length()-1; i>=0; i--){
        tmp += str[i];
    }
    long long answer = stoll(tmp);
    return answer;
}
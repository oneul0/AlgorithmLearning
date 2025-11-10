#include <string>

using namespace std;
int solution(int n)
{
    string tmp = to_string(n);
    int answer = 0;
    for(int i = 0; i<tmp.length(); i++){
        answer += tmp[i]-'0';
    }
    return answer;
}
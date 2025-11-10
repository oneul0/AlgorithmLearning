#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    string tmp = to_string(x);
    int s = 0;
    for(int i = 0; i<tmp.length(); i++){
        s += tmp[i]-'0';
    }
    return x % s == 0;
}

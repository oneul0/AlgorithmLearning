#include <cmath>

using namespace std;

long long solution(int a, int b) {
    
    long long answer = 0;
    if(a==b) return a;
    
    int start = min(a,b), end = max(a,b);
    for(int i = start; i<=end; i++) answer+=i;
    return answer;
}
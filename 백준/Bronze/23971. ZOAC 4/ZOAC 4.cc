#include <iostream>
#include <cmath>
using namespace std;

int main(){
    double h, w, n, m;
    cin >> h >> w >> n >> m;
    int answer = (int) ceil(h/(n+1))* (int) ceil(w/(m+1));
    cout << answer;

    return 0;
}
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int w=0,h=0;
    for(int i = 0; i<sizes.size(); i++){
        int large = max(sizes[i][0], sizes[i][1]); //현재 명함의 가장 긴 면
        int small = min(sizes[i][0], sizes[i][1]); //현재 명함의 가장 작은 면
        w = max(w, large); //각각의 명함 중에서 가장 긴 면
        h = max(h, small); //각각의 명함 중에서 가장 짧은 면
    }

    return w*h;
}

int main(){
    vector<vector<int>> sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
    cout << solution(sizes);
}
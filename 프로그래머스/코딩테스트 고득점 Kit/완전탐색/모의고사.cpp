#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer, tmp(3,0);
    
    vector<vector<int>> supos = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
    int asize = supos[0].size(), aidx=0;
    int bsize = supos[1].size(), bidx=0;
    int csize = supos[2].size(), cidx=0;
    for(int i = 0; i<answers.size(); i++){
        tmp[0] += (answers[i] == supos[0][i%asize]);
        tmp[1] += (answers[i] == supos[1][i%bsize]);
        tmp[2] += (answers[i] == supos[2][i%csize]);
    }
    int maxNum = *max_element(tmp.begin(), tmp.end());
    for(int i = 0; i<3; i++){
        if(tmp[i]== maxNum) answer.push_back(i+1);
    }
    return answer;
}

int main(){
    vector<int> answers = {1,3,2,4,2};
    for(auto a : solution(answers)){
        cout << a<<" ";
    }
    return 0;
}
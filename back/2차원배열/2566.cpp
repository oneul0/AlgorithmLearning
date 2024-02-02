#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int main(){
    int max_final = 0;
    int idx_i = 0;
    int idx_j = 0;
    vector<vector<int>> v(9, vector<int>(9,0));
    for(int i = 0; i<9; i++){
        for(int j = 0; j<9; j++){
            int tmp;
            cin >> tmp;
            v[i][j] = tmp;
        }
    }

    for(int i = 0; i<9; i++){
        int max = *max_element(v[i].begin(), v[i].end());
        int index = max_element(v[i].begin(), v[i].end()) - v[i].begin();
        if(max>max_final){
            max_final = max;
            idx_i = i;
            idx_j = index;
        }
    }

    cout<<max_final<<'\n'<<idx_i+1<<' '<<idx_j+1;

    return 0;
}
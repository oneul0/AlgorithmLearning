#include<vector>
#include<iostream>

using namespace std;

int main(){

    
    vector<int> v[5];

    for(int i = 0; i<5; i++){
        int n;
        cin >> n;

        v[i].push_back(n);
    }

    return 0;
}
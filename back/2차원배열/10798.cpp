#include<iostream>
#include<vector>
#include<string>
#include<queue>

using namespace std;

int main(){
    vector<queue<char>> v;
    for(int i = 0; i<5; i++){
        string tmp;
        cin >> tmp;
        queue<char> v2;
        for(char c : tmp){
            v2.push(c);
        }
        v.push_back(v2);
    }

    while(v[0].size()+v[1].size()+v[2].size()+v[3].size()+v[4].size()){
        for(int i = 0; i<v.size(); i++){
            if(!v[i].empty()){
                char x = v[i].front();
                v[i].pop();
                cout << x;
            }
        
        }
    }
    
    return 0;
}
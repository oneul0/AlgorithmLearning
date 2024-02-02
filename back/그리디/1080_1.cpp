#include <iostream>
#include <vector>
#include <string>

using namespace std;

void conv(vector<vector<char>>& v, int x, int y){
    for(int i = x; i<x+3; i++){
        for(int j = y; j<y+3; j++){
            v[i][j] = (v[i][j]=='0'? '1':'0');
        }
    }
}

bool chk(const vector<vector<char>>& a, const vector<vector<char>> b, int n, int m){
    for(int i = 0; i<n; i++){
        for(int j = 0; j< m; j++){
            if(a[i][j] != b[i][j]){
                return false;
            }
        }   
    }
    return true;
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int n,m;
    string tmp;
    int cnt = 0;
    vector<vector<char>> a, b;

    cin >> n>> m;

    a.resize(n); b.resize(n);

    for(int i = 0; i<n; i++){
        cin >> tmp;
        for(char& c: tmp){ 
            a[i].push_back(c);
        }
    }

    for(int i = 0; i<n; i++){
        cin >> tmp;
        for(char& c: tmp){ 
            b[i].push_back(c);
        }
    }

    for(int i = 0; i<n-2; i++){
        for(int j = 0; j<m-2; j++){
            if(a[i][j] != b[i][j]){
                cnt++; conv(a, i, j);
            }
        }
    }

    cout<< (chk(a, b, n, m) ? cnt : -1);
    

    return 0;
}
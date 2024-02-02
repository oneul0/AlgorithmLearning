#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int n,m;
    string s;
    vector<string> v;
    cin>>n>>m;
    v.resize(n+1);
    v[0] = "0";
    for(int i = 1; i<=n; i++){
        cin >> v[i];
    }
    for(int i = 0; i<m; i++){
        cin >> s;
        auto it = find(v.begin(), v.end(), s);
        if(it != v.end()) cout << it - v.begin()<<'\n';
        else{
            int tmp = stoi(s);
            cout << v[tmp] << '\n';
        }
    }
    return 0;
}
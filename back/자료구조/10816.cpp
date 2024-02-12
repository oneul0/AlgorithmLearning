#include <iostream>
#include <unordered_map>
#include <algorithm>

using namespace std;

int n;
string s;
unordered_map<string, int> m;

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >>n;
    while(n--){
        cin >> s;
        m[s]++;
    }
    cin >> n;
    while(n--){
        cin >> s;
        if(m.find(s) == m.end())
            cout << 0 << " ";
        else
            cout << m[s]<<" ";
    }
    return 0;
}
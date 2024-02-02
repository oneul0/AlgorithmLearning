#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

struct cmp{
    bool operator() (const string &s1, const string &s2) const{
        if(s1.length() != s2.length()) return s1.length() < s2.length();
        else return s1 < s2;
    }
};


int n;
string s;
set<string,cmp> v;

int main(){
    cin >> n;
    while(n--){
        cin >> s;
        v.insert(s);
    }

    //sort(v.begin(), v.end(), cmp);

    for(auto& w : v) cout << w << "\n";

    return 0;
}
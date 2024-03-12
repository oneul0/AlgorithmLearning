#include <iostream>
#include <vector>
#include <algorithm>
#include <map>

using namespace std;

string s;
vector<int> symbol;
vector<pair<int,int>> pv;
vector<int> visited;
void check(int i , int count);
map<string,int> m;

int main(){
    cin >> s;
    for(int i = 0; i<s.length(); i++){
        if(s[i] == '('){
            symbol.push_back(i);
        }
        else if(s[i] == ')'){
            int num = symbol[symbol.size() -1];
            symbol.pop_back();
            pv.push_back(make_pair(num,i));
        }
    }
    visited.resize(s.length(), 0);
    check(0,0);
    for(auto iter=m.begin(); iter!=m.end(); iter++){
        cout << iter->first<<'\n';
    }
    return 0;
}
void check(int i, int count){
    if(count > 0){
        string tmp = "";
        for(int j = 0; j<visited.size(); j++){
            if(visited[j]) continue;
            else tmp+=s[j];
        }
        m.insert({tmp,1});
    }
    for(int k = i; k<pv.size(); k++){
        if(visited[pv[k].first] && visited[pv[k].second]) continue;
        visited[pv[k].first] = visited[pv[k].second] = true;
        check(k, count +1);
        visited[pv[k].first] = visited[pv[k].second] = false;
    }
}
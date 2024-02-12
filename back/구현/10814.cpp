#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;
//sort stable sort 문제인듯
//sort는 퀵정렬, stable sort는 합병정렬인데, sort는 기존 순서를 보장하지 않는 반면, stable sort는 기존 순서를 보장함
int n, age;
string name;
vector<pair<int,string>> v;
bool cmp(pair<int, string> a, pair<int, string> b){
    return a.first < b.first;
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    cin >> n;
    for(int i = 0; i<n; i++){
        cin >> age >> name;
        v.push_back(make_pair(age, name));
    }
    stable_sort(v.begin(), v.end(), cmp);
    for(auto& a : v){
        cout << a.first <<" "<<a.second<<'\n';
    }
    return 0;
}
#include <iostream>
#include <map>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

/*
2
101 1
103 3
3
solved 103
add 103 3
recommend 1

*/

string cmd;
int N, P, M, L, x;
map<int, int, greater<int>> r;
vector<pair<int,int>> v;
bool cmp(const pair<int, int>& a, const pair<int, int>& b) {
    if (a.second == b.second) return a.first > b.first;
    return a.second > b.second;
}

void recmd(int x){
    v.assign(r.begin(), r.end());
    sort(v.begin(), v.end(), cmp);
    int prob_no = 0;
    
    if(x == 1){
        auto first_element = v.begin();
        prob_no = first_element->first;
    }
    if(x == -1){
        auto last_element = v.end();
        --last_element;
        prob_no = last_element->first;
    }
    //문제 번호 내림차순, 난이도 내림차순
    cout << prob_no<<'\n';
}

void addcmd(int prob, int lv){
    if(r.find(prob) != r.end()){
        r.erase(prob);
    }
    r.insert({prob,lv});
}

void solvedcmd(int prob){
    if(r.find(prob) != r.end()){
        r.erase(prob);
    }
}

void list_update(string cmd){
    if(cmd == "recommend"){
        cin >> x;
        recmd(x);
    }
    else if(cmd == "add"){
        cin >> P >> L;
        addcmd(P, L);
    }
    else if(cmd == "solved"){
        cin >> P;
        solvedcmd(P);
    }
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
    cin >> N;
    for(int i = 0; i<N; i++){
        cin >> P >> L;
        r.insert({P, L});
    }

    v.assign(r.begin(), r.end());
    sort(v.begin(), v.end(), cmp);

    cin >> M;
    for(int i = 0; i<M; i++){
        cin >> cmd;
        list_update(cmd);
    }

    return 0;
}
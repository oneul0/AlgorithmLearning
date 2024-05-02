#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

struct cmp1{
    bool operator()(pair<int,int> a, pair<int,int> b){
        if(a.second==b.second){
            return a.first<b.first;
        }
        //swap 조건
        return a.second < b.second;
    }
};

struct cmp2{
    bool operator()(pair<int,int> a, pair<int,int> b){
        if(a.second==b.second){
            return a.first>b.first;
        }
        return a.second > b.second;
    }
};

priority_queue<pair<int,int>, vector<pair<int,int>>, cmp1> hardestPq;
priority_queue<pair<int,int>, vector<pair<int,int>>, cmp2> easiestPq;
bool isAlive[100001] = {false};
int n, p, l, m;
string cmd;

void add(){
    cin >> p >> l;
    hardestPq.push({p,l});
    easiestPq.push({p,l});
    isAlive[p] = true;
}
void solved(){
    cin >> p;
    isAlive[p] = false;
    while(!isAlive[hardestPq.top().first]){
            hardestPq.pop();
    }
    while(!isAlive[easiestPq.top().first]){
            easiestPq.pop();
    }
}
void recommend(){
    cin >> l;
    
    if(l==1) {
        cout << hardestPq.top().first <<'\n';
    }
    else {
        cout << easiestPq.top().first << '\n';
    }
}


void command(string cmd){
    switch (cmd[0])
    {
        //add
    case 'a':
        add();
        break;
        //recommend
    case 'r':
        recommend();
        break;
        //solved
    case 's':
        solved();
        break;
    default:
        break;
    }

}


int main(){
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
    cin >> n;
    for(int i = 0; i<n; i++){
        cin >> p >> l;
        hardestPq.push({p,l});
        easiestPq.push({p,l});
        isAlive[p] = true;
    }

    cin >> m;
    for(int i =0; i<m; i++){
        cin >> cmd;
        command(cmd);
    }
    return 0;
}
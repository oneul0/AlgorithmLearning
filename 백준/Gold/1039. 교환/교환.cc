#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#include <set>

using namespace std;

string n;
int k;

void bfs(){
    int len = n.size();

    queue<string> q;
    q.push(n);

    for(int i = 0; i<k; i++){
        set<string> chk;
        int qsize = q.size();
        for(int j = 0; j<qsize; j++){
            string sn = q.front();
            q.pop();
            if(chk.count(sn)) continue;

            chk.insert(sn);
            for(int a = 0; a < len-1; a++){
                for(int b = a+1; b<len; b++){
                    if(a == 0 && sn[b] == '0') continue;
                    swap(sn[a],sn[b]);
                    q.push(sn);
                    swap(sn[a], sn[b]);
                }
            }
        }
    }
    string ans = "0";
    while(!q.empty()){
        ans = max(ans, q.front());
        q.pop();
    }
    if(ans[0] == '0') cout << "-1";
    else cout << ans;
}


int main(){
    cin >> n >> k;
    bfs();
    
    return 0;
}
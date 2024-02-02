#include<iostream>
#include<vector>
#include<tuple>

using namespace std;

#define MAXNUM 100
vector<tuple<int,int,int>> vt;
vector<vector<vector<int>>> v(MAXNUM, vector<vector<int>>(MAXNUM, vector<int>(MAXNUM,-1)));

int w(int a, int b, int c){
    if(a<=0 || b <= 0 || c <= 0){
        return 1;
    }

    if(v[a][b][c] == -1){
        if(a>20 || b>20||c>20){
            v[a][b][c] = w(20, 20, 20);
        }
        else if(a<b && b<c){
            v[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
        }
        else{
            v[a][b][c] = w(a-1,b,c) + w(a-1, b-1, c)+w(a-1, b, c-1)- w(a-1, b-1, c-1);
        }
    }
    return v[a][b][c];
}

int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int a,b,c;
    

    while(1){
        cin >> a >> b>> c;
        if(a == -1 && b == -1 && c == -1){break;}
        else{
            tuple<int,int,int> t;
            t = make_tuple(a,b,c);
            vt.push_back(t);
        }
        
    }
    for(int i = 0; i<vt.size(); i++){
        int a1,b1,c1;
        a1 = get<0>(vt[i]);
        b1 = get<1>(vt[i]);
        c1 = get<2>(vt[i]);
        
        cout << "w("<<a1 <<", "<<b1<<", "<<c1<<") = "<< w(a1,b1,c1)<<"\n";
    }
    
    
    return 0;
}
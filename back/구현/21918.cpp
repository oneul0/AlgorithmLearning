#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


vector<bool> v;

vector<bool> command(int a, int b, int c){
    if(a==1){
        v[b] = c;
    }
    else if(a==2){
        transform(v.begin()+b, v.begin()+c, v.begin()+b, [](bool blub) {return !blub; });
    }//다시
    else if(a==3){
        //l~r off
        fill(v.begin() + b, v.begin() + c, false);
    }
    else if(a==4){
        //l~r on
        fill(v.begin() + b, v.begin() + c, true);
    }
    return v;
}


int main(){
    ios_base::sync_with_stdio(0); cin.tie(0);
    int n,m,a,b,c;
    bool state;

    cin >> n >> m;
    for(int i = 0; i<n; i++){
        cin >> state;
        v.push_back(state);
    }
    
    for(int i = 0; i<m; i++){
        cin >> a >> b >> c;
        v = command(a,b-1,c);
    }

    for(bool c: v){
        cout << c <<" ";
    }
        

    return 0;
}
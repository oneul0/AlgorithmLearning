#include<iostream>
#include<vector>
#include<algorithm>
#include<string>
#include <sstream>

using namespace std;

int main(){
    string s;

    cin >> s;

    istringstream ss(s);
    string tmp;
    vector<string> v;

    while(getline(ss,tmp,'-')){
        v.push_back(tmp);
    }

    vector<int> v2;
    for(auto& a : v){
        istringstream ss(a);
        int tot = 0;
        while(getline(ss,tmp,'+')){
            tot += stoi(tmp);
            
        }
        v2.push_back(tot);
    }
    
    int fir = v2[0];

    for(int i = 1; i<v2.size(); i++){
        fir -= v2[i];
    }
    cout << fir;
    return 0;
}


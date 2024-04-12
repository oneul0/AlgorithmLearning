#include <iostream>
#include <map>
#include <string>
#include <vector>

using namespace std;

int main(){
    map<string,int> m;
    int cnt = 0;
    while(1){
        string s = "";
        getline(cin,s);
        if (s == "") break; 
        cnt++;
        m[s]++;
    }
    
    for(map<string,int>::iterator iter = m.begin(); iter!=m.end(); iter++){
        cout<<fixed;
        cout.precision(4);
        cout << iter->first << " "<<(double)(iter->second)/cnt*100 <<'\n';
    }
    
    return 0;
}
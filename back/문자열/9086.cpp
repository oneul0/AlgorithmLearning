#include <iostream>
#include <string>
#include <vector>


using namespace std;

int main(){
    string sen;
    vector<string> senten;
    int t;
    cin >> t;
    for(int i = 0; i<t; i++){
        cin >> sen;
        senten.push_back(sen);
    }

    for(int i = 0; i<t; i++){
        string c = senten[i].substr(0,1);
        cout << c << senten[i].back() << "\n";
        
    }

    return 0;
}
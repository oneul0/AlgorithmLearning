#include <iostream>
#include <map>

using namespace std;

int n, age;
map<string, int> m;
string name;
int main(){
    cin >> n;
    while(n--){
        cin >> age >> name;
        m.insert(make_pair(name, age));
    }
    
    return 0;
}
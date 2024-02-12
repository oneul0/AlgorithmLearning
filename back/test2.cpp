#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

bool cmp(char c1, char c2){
    if(atoi(c1) == atoi(c2)) return FALSE;
}

int main() {
    string s;
    int n;
    vector<string> v;
    cin >> n;
    v.resize(n);
    for(int i = 0; i<n; i++){
        cin >> v[i];
    }
    



	return 0;
}
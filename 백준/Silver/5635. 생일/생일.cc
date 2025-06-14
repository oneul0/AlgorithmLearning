#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

bool compare(pair<int, string> a, pair<int, string> b){
    return a.first > b.first;
}

int main(){
    int n;
    cin >> n;
    vector<pair<int, string>> v(n);
    string yy, mm, dd;
    string name;
    for(int i = 0; i<n; i++){
        cin >> name >> dd>>mm>>yy;
        mm = (mm.length() == 1 ? "0"+mm : mm);
        dd = (dd.length() == 1 ? "0"+dd : dd);
        string tmp = yy+mm+dd;
        v[i] = make_pair(stoi(tmp), name);
    }

    sort(v.begin(), v.end(), compare);

    cout << v.front().second << endl << v.back().second;

    return 0;
}

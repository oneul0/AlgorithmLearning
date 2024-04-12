#include <iostream>
#include <vector>
#include <algorithm>
#include <set>
using namespace std;

int main(){
    set<int> X, Y;
    set<pair<int, int>> printedPairs;
    vector<pair<int,int>> v(3);
    
    // Input
    for(int i = 0; i < 3; i++){
        int a, b;
        cin >> a >> b;
        v[i].first = a;
        v[i].second = b;
        X.insert(a);
        Y.insert(b);
    }
    
    for(set<int>::iterator iterX = X.begin(); iterX != X.end(); iterX++){
        for(set<int>::iterator iterY = Y.begin(); iterY != Y.end(); iterY++){
            int x = *iterX;
            int y = *iterY;
            bool printed = false;
            for(int i = 0; i < 3; i++){
                if(v[i].first == x && v[i].second == y) {
                    printed = true;
                    break;
                }
            }
            if (!printed && printedPairs.find({x, y}) == printedPairs.end()) {
                cout << x << " " << y << endl;
                printedPairs.insert({x, y});
            }
        }
    }

    return 0;
}

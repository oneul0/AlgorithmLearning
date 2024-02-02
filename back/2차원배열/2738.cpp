#include<iostream>
#include<vector>

using namespace std;

int main(){
    int n,m;
    cin >> n >>m;
    
    vector<vector<int>> v[2];
    vector<vector<int>> v2(n, vector<int>(m,0));
    for(int i = 0; i<2; i++){
        v[i] = vector<vector<int>>(n, vector<int>(m,0));
    }

    for(int k = 0; k<2; k++){
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                int num;
                cin >> num;
                v[k][i][j] = num;
            }
        }
    }
    
    for(int i = 0; i<n; i++){
        for(int j = 0; j<m; j++){
            int temp = v[0][i][j]+v[1][i][j];
            cout << temp <<" ";
            //v2[n].push_back(temp);
        }
        cout<< '\n';
    }

    
    return 0;
}
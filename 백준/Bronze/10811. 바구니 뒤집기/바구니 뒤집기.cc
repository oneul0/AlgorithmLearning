#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int n,m, a,b;

int main() {
  ios_base::sync_with_stdio(false); cin.tie(0); cout.tie(0);
  cin >> n >> m;
  vector<int> v(n+1,0);
  for(int i = 1; i<=n; i++){
    v[i] = i;
  }
  for(int i = 0; i<m; i++){
    cin >> a >> b;
    for(int i = 0; i<=(b-a)/2; i++){
      swap(v[a+i], v[b-i]);
    }
  }

  for(int i = 1; i<=n; i++) cout << v[i] << " ";
  return 0;
}

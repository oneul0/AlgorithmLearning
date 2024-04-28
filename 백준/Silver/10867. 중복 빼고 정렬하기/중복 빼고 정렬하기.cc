#include <iostream>
#include <set>
using namespace std;

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int n,m;
	set<int> st;
	cin >> n;
	for(int i = 0; i<n; i++){
		cin >> m;
		st.insert(m);
	}
	for(set<int>::iterator iter = st.begin(); iter != st.end(); iter++){
		cout << *iter<<" ";
	}
	return 0;
}
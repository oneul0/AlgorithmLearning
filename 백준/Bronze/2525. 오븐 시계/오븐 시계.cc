#include <iostream>
using namespace std;

int main() {
	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);
	int h,m;
	int t;
	cin >> h >> m >> t;
	int gh = h;
	int gm = m+t;
	if(gm >= 60){
		gh += (gm/60);
		gm %= 60;
	}
	if(gh >= 24){
		gh %= 24;
	}
	cout << gh <<" "<<gm;
	return 0;
}
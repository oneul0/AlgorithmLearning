#include<iostream>
#include <map>
using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false);cin.tie(nullptr);
	int test_case;
	int T;

	cin>>T;

	for(test_case = 1; test_case <= T; ++test_case)
	{
        int a,b,ans;
        cin >> a>>b;
        ans = a*b;
        if(a >9 || b>9) ans = -1;
        cout << '#'<<test_case<<" "<<ans<<'\n';
	}
	return 0;
}
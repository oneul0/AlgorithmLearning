#include<iostream>

using namespace std;

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
	int test_case;
	int T,l,u,x;
	cin>>T;
	for(test_case = 1; test_case <= T; ++test_case)
	{
        int ans = 0;
        cin >> l >> u >> x;
        if(x>u) ans = -1;
        else if(x<l) ans = l-x;
        
        cout << '#' << test_case << " " << ans <<'\n';
	}
	return 0;
}
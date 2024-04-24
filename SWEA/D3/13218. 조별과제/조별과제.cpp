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
        cin >> l;
        if(l == 0) u = 0;
        else u = l/3;
        cout << '#' << test_case << " " << u <<'\n';
	}
	return 0;
}
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
        
        cout << '#' << test_case << " " << l*l <<'\n';
	}
	return 0;
}
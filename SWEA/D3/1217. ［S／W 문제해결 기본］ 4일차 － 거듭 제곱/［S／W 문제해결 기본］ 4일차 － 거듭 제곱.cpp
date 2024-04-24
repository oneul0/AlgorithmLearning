#include<iostream>
using namespace std;


int n, p, base = 1;
//값, 깊이
//깊이가 입력만큼 안되면
//베이스 수를 곱해서 다음으로
int pow(int base, int depth){
	if(depth == p) return base;
	return pow(base*n, depth+1);
}

int main(int argc, char** argv)
{
    ios_base::sync_with_stdio(false); cin.tie(nullptr);
	int test_case;
	int T;

    for(int i = 0; i<10; i++)
	{
		cin >> test_case;
		base = 1;
		cin >> n >> p;
		int ans = pow(base, 0);
		cout << '#' << test_case << " "<< ans <<'\n';
	}
	

	return 0;
}
#include <iostream>
#include <cmath>

using namespace std;

const int num = 500;
//const int num = 5;

int numOfDivisons(long long int n){
	int len = (long long int)sqrt(n);
	int ret = 0;
	for(int i = 1; i <= len; i++)
		if(n % i == 0)
			ret += 2;
	if(len * len == n)
		ret--;

	return ret;
}
int main(){
	long long int  sum = 1;
	long long int  base = 2;
	while(true){
		sum += base;
		base++;
		if(sum < 0)
			cout << "bad" << endl;
		if(numOfDivisons(sum) > num)
			break;
	}

	cout << sum << endl;
	return 0;
}

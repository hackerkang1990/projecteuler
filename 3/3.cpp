#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

const long long int num = 600851475143;

bool judge_prime(int n, vector<int> &prime){
	for(vector<int>::iterator it = prime.begin(); it != prime.end(); it++){
		if(n % *it == 0)
			return false;
	}
	return true;
}
int main(){
	vector<int> prime;
	prime.push_back(2);
	int budder = (int)sqrt((double)num);
	int ret = 0;
	for(int i = 3; i <= budder; i++){
		if(judge_prime(i, prime) == true){
			prime.push_back(i);
			if(num % i == 0)
				ret = i;
		}
	}
	if(ret != 0)
		cout << ret << endl;
	else
		cout << num << endl;
	return 0;
}

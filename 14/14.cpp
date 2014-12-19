#include <iostream>
#include <climits>
#include <cstring>

using namespace std;

const int num = 1000000;

long long int f[1000000];

int main(){
	long long int count = 1;
	int ret = 1;
	f[1] = 1;
	for(long long int i = 2; i < num; i++){
		long long int j = i;
		long long int len = 0;
		while(true){
			while((j & 1) == 0){
				j = j >> 1;
				len++;
			}
			if(j < i)
				break;
			j = j * 3 + 1;
			len++;
		}

		if(j <= 0) cout << "bad" << endl;

		f[i] = len + f[j];
		if(f[i] > count){
			count = f[i];
			ret = i;
		}
	}

	cout << "f[10] is " << f[10] << endl;
	cout << ret << endl;
	return 0;
}

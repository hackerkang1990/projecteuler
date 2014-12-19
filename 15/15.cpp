#include <iostream>

using namespace std;

const int num = 20;

int main(){
	long long int f[100][100];
	for(int i = 0; i <= num; i++){
		f[i][0] = 1;
		f[0][i] = 1;
	}
	for(int i = 1; i <= num; i++){
		for(int j = 1; j <= num; j++){
			f[i][j] = f[i-1][j] + f[i][j-1];
			if(f[i][j] < 0)
				cout << "bad" << endl;
		}
	}

	cout << f[num][num] << endl;
	return 0;
}

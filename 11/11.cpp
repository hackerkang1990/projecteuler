#include <iostream>
#include <algorithm>

using namespace std;

const int num = 4;
const int len = 20;

int main(){
	int matrix[100][100];
	for(int i = 0; i < len; i++){
		for(int j = 0; j < len; j++){
			cin >> matrix[i][j];
			//cout << matrix[i][j] << " ";
		}
		//cout << endl;
	}
	int ret = 0;
	for(int i = 0; i < len; i++){
		for(int j = 0; j < len; j++){
			//up down
			if(i < len - num){
				int sum = 1;
				for(int x = i; x < i + num; x++)
					sum *= matrix[x][j];
				ret = max(ret, sum);
			}
			if(j < len - num){
				int sum = 1;
				for(int y = j; y < j + num; y++)
					sum *= matrix[i][y];
				ret = max(ret, sum);
			}

			if(i < len - num && j < len - num){
				int sum = 1;
				for(int x = i, y = j; x < i + num; x++, y++)
					sum *= matrix[x][y];
				ret = max(ret, sum);
			}
			if(i < len - num && j >= num - 1){
				int sum = 1;
				for(int x = i, y = j; x < i + num; x++, y--)
					sum *= matrix[x][y];
				ret = max(ret, sum);
			}
		}
	}

	cout << ret << endl;
	return 0;
}

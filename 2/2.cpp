#include <iostream>

using namespace std;

int main(){
	int sum = 0;
	int a = 0, b = 1, c = 1;
	while(c <= 4000000){
		if(c % 2 == 0)
			sum += c;
		c = a + b;
		a = b;
		b = c;
	}

	cout << sum << endl;
	return 0;
}

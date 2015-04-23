#include<iostream>
#include<cstdlib>
#include<cstring>
using namespace std;

size_t count_calls(){
	static size_t ctr = 0;
	return ++ctr;
}
int main(){
	string s = "www";
	s.find("w");
	s.find_first_of("w");
	char str[] = "eee";
	cout<<strlen(str);
	system("pause");
	return 0;
}
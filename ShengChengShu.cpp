/**
找到满足条件的数组
给定函数d(n)=n+n的各位之和，n为正整数，如d(78)=78+7+8=93。这样这个函数可以看成一个生成器，如93可以看成由78生成。
定义数A：数A找不到一个数B可以由d(B)=A，即A不能由其他数生成。现在要写程序，找出1至10000里的所有符合数A定义的数。
回答：
申请一个长度为10000的bool数组，每个元素代表对应的值是否可以有其它数生成。开始时将数组中的值都初始化为false。
由于大于10000的数的生成数必定大于10000，所以我们只需遍历1到10000中的数，计算生成数，并将bool数组中对应的值设置为true，表示这个数可以有其它数生成。
最后bool数组中值为false的位置对应的整数就是不能由其它数生成的。
**/
#include<iostream>
#include<cstring>
#include<cstdio>
#include<cstdlib>
using namespace std;
bool numbers[10001];
int main(){
	memset(numbers,0,sizeof(numbers));
	for(int i=1;i<=10000;i++) {
		int target = i,re = i;
		while(target>0){
			re += target%10;
			target = target/10;
		}
		numbers[re] = true;
	}
	for(int i=1;i<=10000;i++) {
		if(!numbers[i])
			printf("%d\t",i);
	}
	system("pause");
return 0;
}
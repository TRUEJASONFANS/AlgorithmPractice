/*上一周我们研究了2xN的骨牌问题，这一周我们不妨加大一下难度，研究一下3xN的骨牌问题？
所以我们的题目是：对于3xN的棋盘，使用1x2的骨牌去覆盖一共有多少种不同的覆盖方法呢？
首先我们可以肯定，奇数长度一定是没有办法覆盖的；对于偶数长度，比如2，4，我们有下面几种覆盖方式：
*/
#define ll long long
#include <iostream>
using namespace std;
const int MAXN= 100000000;
const int constN = 8;
const ll MOD = 12357;
int n;
ll re = 0;
int c[constN][constN] ={
    	         0,0,0,0,0,0,0,1,
				 0,0,0,0,0,0,1,0,
				 0,0,0,0,0,1,0,0,
				 0,0,0,0,1,0,0,1,
				 0,0,0,1,0,0,0,0,
				 0,0,1,0,0,0,0,0,
				 0,1,0,0,0,0,0,1,
				 1,0,0,1,0,0,1,0		
				};
typedef struct Matrix{
	int (*a)[constN];
	Matrix(int (*b)[constN]){
		a = new int [constN][constN];
		for(int i=0;i<constN;i++) {
			for(int j=0;j<constN;j++){
				a[i][j] = b[i][j];
			}
		}
	};
	Matrix  operator*(const Matrix &m1) const{
	 	 Matrix temp(c);
	 	 for(int i=0;i<constN;i++) {
	 	 	for(int j=0;j<constN;j++) {
	 	 		int sum=0;
	 	 		for(int k1=0;k1<constN;k1++)
	 	 			sum+=a[i][k1]*m1.a[k1][j];
	 	 		temp.a[i][j] = sum%MOD;
	 	 	}
	 	 }
	 	 return temp;
	};
}Matrix;
Matrix solve(const Matrix &a,int n){
	Matrix tmp(c);
	if(n==1||n==0) return tmp;
	tmp = solve(a,n/2);
	if(n&1) {
		tmp = tmp*tmp*a;
	}
	else {
		tmp = tmp*tmp;
	}
	return tmp;
}
int main(){
	Matrix m(c);
	while(cin>>n){
		if(n%2==1) {
			cout<<"0"<<endl;
		}
		else {
			 m = solve(m,n);
			 cout<<m.a[7][7]<<endl;
		}
	}
}

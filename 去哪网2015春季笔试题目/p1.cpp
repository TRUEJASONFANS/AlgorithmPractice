#include<iostream>
#include<vector>
using namespace std;
/**
注意其单调性
**/
int binarySearch(int a[],int s,int e,int target) {

	while(s<e) {
		int mid = (s+e)/2;
		if(a[mid]==target) return mid;
		if(a[mid]>target) {
			e = mid - 1;
		}
		else {
			s = mid + 1;
		}
	}
	return -1;
}
int findLocation(int a[],int s,int e,int target) {

	int mid = (s+e)/2;
	if(a[mid]==target) return mid;
	else if(s==e) return -1;
	else {//target!=a[mid];
		if(a[mid]>a[s]) {//[s,mid]为左递增子序列,[mid,e]为一个全新的子问题序列;
			if(a[s]<=target&&target<=a[mid])
				return binarySearch(a,s,mid,target);
			else 
				return findLocation(a,mid,e,target);//
		}
		else if(a[mid]<a[s]){//[s,mid]为一个全新的子问题序列,[mid,e]为一个增序列,且存在a[s]>a[e];
			if(a[mid]<=target&&target<=a[e]) 
				return binarySearch(a,s,mid,target);
			else
				return findLocation(a,mid,e,target);
		}
		else {//a[mid]==a[s],查找a[mid,e]即可
			return findLocation(a,mid,e,target);
		}
	}
	return -1;
}
int indexofArray(int a[],int target,int len) {
	int re = -1;
	re = findLocation(a,target,0,len);
	return re;
}
int main(){

	int a[5] = {3,4,5,1,2};
	cout << indexofArray(a,5,1);

}
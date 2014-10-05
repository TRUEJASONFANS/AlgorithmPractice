#include <cstdio>
#include <cstring>
#include <iostream>
#include <queue>
using namespace std;
struct Node {
	char ch;
	Node *child, *bro, *fa, *next;
	bool b;
	Node(char ch) :
			ch(ch), child(NULL), bro(NULL), fa(NULL), next(NULL), b(0) {
	}
	;

} *root = new Node(0);
void put(string str){
	int sLen = str.size();
	Node *p = root;
	for(int i = 0; i < sLen; i++) {
		Node *pc = p->child ;
		while(pc!=NULL&&pc->ch != str[i]){
			pc = pc->bro;
		}
		if(pc==NULL) {
			Node *t = new Node(str[i]);
			t->bro = p->child;
			p->child = t;
			t->fa = p;
			p = t;
		}//不存在则新建一个
		else {
			p = pc ;
		}//已经存在该节点。
	}
	p -> b = 1;
}
Node* in(Node *r, char ch) {
	for (Node* tmp = r->child; tmp; tmp = tmp->bro) {
		if (tmp -> ch == ch)
			return tmp;
	}
	return NULL;
}
void bfs(){
	queue<Node *> myqueue;
	myqueue.push(root);
	while(!myqueue.empty()){
		Node *t = myqueue.front();
		myqueue.pop();
		for (Node *tmp = t; tmp; tmp = tmp->bro) {
			if(tmp==root)
				 tmp->next = NULL;
			else if(tmp->fa == root)
				 tmp->next = root;
			else {
				Node* tmpfa = tmp->fa->next;
				while(tmpfa!=NULL&&in(tmpfa,tmp->ch)==NULL)
					tmpfa = tmpfa->next;
				if(tmpfa==NULL)
					tmp->next = NULL;
				else
					tmp->next = in(tmpfa,tmp->ch);

			}
		}
		if(t->child)
			myqueue.push(t->child);
	}
}
bool find(string s){

	Node* t = root;
	for (int i = 0,slen = s.size(); i < slen; i++) {
		while(t!=NULL&&in(t,s[i])==NULL)
			t = t->next;
		if(t==NULL)
			t = root;
		else
			t = in(t,s[i]);//
		if(t->b)
			return 1;
	}
	return 0;
}
int main() {
	int n = 0;
	string paper,str;
	scanf("%d", &n);
	while (n-- > 0) {
		cin>>str;
		put(str);
	}
	bfs();
	cin>>paper;
	printf("%s\n",find(paper)?"YES":"NO");
	return 0;
}

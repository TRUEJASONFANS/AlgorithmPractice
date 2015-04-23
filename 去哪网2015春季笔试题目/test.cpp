#include <iostream.h>
class Node{ 
public:
       Node(){};
       virtual~Node(){};
       virtual int eval()=0;
} ;   
class Binop:public Node{  
public:
       Node  * left, * right ;
       ~Binop(){ 
        delete left;
        delete reight;
       }
       Binop(Node  *l, Node *r) {
          left = l;
          right = r; 
       }   
}；
class Plus: public Binop{  
public:
      Plus(Node *l, Node * r) :Binop(l,r){ }
      int eval() { 
          return left->eval() + right->eval();
      }
}；
class Uminus:public Node {    // 负号运算符类
             Node   * operand ;
       public:
             Uminus(Node * op) { operand = op ;}
             ~Uminus() { delete operand ; }
             int eval() { op->value = -op->value;}
};
class Int : public Node {
             int value;
      public:
             Int(int v) { value = v; }
             int eval() { return  value; }
};
int  main() {
// 构建 -5+（12 + 4）的表达式树
Node * np =
   new  Plus (
           new Uminus(
                   new Int(5)
           ) ,
           new Plus(
                   new Int(12) ,
                   new Int(4)
           )
   );
   int result = np - > eval () ;
delete np;
cout<<”The result is ”<< result <<endl;
}
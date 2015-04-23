  /*-------------------------------------
    *   日期：2015-04-10
    *   作者：SJF0115
    *   题目: 合并日期
    *   来源：去哪网
    *   博客：
    ------------------------------------*/
    #include <iostream>
    #include <vector>
    using namespace std;

    struct Interval{
        int start;
        int end;
        int price;
        Interval(int s = 0,int e = 0,int p = 0):start(s),end(e),price(p){}
    };

    vector<Interval> Merge(Interval dateRnagePrice[],int size){
        Interval interval[1001];
        // 最小日期 最大日期
        int min = 1001,max = 0,start,end,price;
        for(int i = 0;i < size;++i){
            start = dateRnagePrice[i].start;
            end = dateRnagePrice[i].end;
            price = dateRnagePrice[i].price;

            if(start < min){
                min = start;
            }//if
            if(end > max){
                max = end;
            }//if
            for(int j = start;j <= end;++j){
                interval[j].price = price;
            }//for
        }//for
        // 合并
        vector<Interval> result;
        Interval date;
        date.start = min;
        for(int i = min+1;i <= max;++i){
            if(interval[i].price != interval[i-1].price){
                date.end = i-1;
                date.price = interval[i-1].price;
                result.push_back(date);
                date.start = i;
            }//if
        }//while
        date.end = max;
        date.price = interval[max].price;
        result.push_back(date);
        return result;
    }

    int main(){
        //Interval dateRnagePrice[] = {Interval(0,100,300),Interval(40,50,350)};
        Interval dateRnagePrice[] = {Interval(2,19,300),Interval(10,40,250),Interval(41,60,250)};
        vector<Interval> result = Merge(dateRnagePrice,3);
        for(int i = 0;i < result.size();++i){
            cout<<"["<<result[i].start<<","<<result[i].end<<","<<result[i].price<<"]"<<endl;
        }//for
        return 0;
    }
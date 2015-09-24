package LeetCode;

import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.Lists;

class Interval {
     int start;
     int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class InsertInterval {

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> result = new ArrayList<Interval>();
 
        for(Interval interval: intervals){
            if(interval.end < newInterval.start){
                result.add(interval);
            }else if(interval.start > newInterval.end){
                result.add(newInterval);
                newInterval = interval;        
            }else if(interval.end >= newInterval.start || interval.start <= newInterval.end){
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
            }
        }
 
        result.add(newInterval); 
 
        return result;	
    }

	public static void main(String[] args) {
		List<Interval> list = Lists.newArrayList(new Interval(1,2),new Interval(3,5));
		new InsertInterval().insert(list, new Interval(1,3));
	}

}

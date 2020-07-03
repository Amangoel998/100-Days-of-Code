package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
    Merge Intervals that intersect/coincide
    Input: 
    N
    a,b
    x,y
    ...
*/
class Interval{
    int start, end;
    Interval(){
        start = 0;
        end = 0;
    }
    Interval(Integer[] nt){
        start = nt[0];
        end = nt[1];
    }
    Interval(int st, int ed){
        start = st;
        end = ed;
    }
    @Override
    public String toString(){
        return "["+start+", "+end+"]";
    }
	static public int compare(Interval o1, Interval o2) {
		return o1.getStart()-o2.getStart();
    }
    public int getStart(){
        return start;
    }
    public int getEnd(){
        return end;
    }
}
public class MergeIntervals {
    private static List<Interval> intervals;
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        intervals = new LinkedList<>();
        for(int i=0;i<N;i++){
            Interval interval = new Interval(Arrays.stream(br.readLine().split("[\\s,]+")).map(Integer::parseInt).toArray(Integer[]::new));
            intervals.add(interval);
        }
        intervals.sort((a,b)-> {
            if(Integer.compare(a.getStart(), b.getStart())==0)
                return Integer.compare(a.getEnd(), b.getEnd());
            return Integer.compare(a.getStart(), b.getStart());
            
        });
        // intervals.stream().sorted(Interval::compare).collect(Collectors.toList());
        mergeIntervals();
        intervals.stream().forEach(System.out::println);
    }
    static void mergeIntervals(){
        int i=1;
        while(i<intervals.size()){
            if(intervals.get(i).getStart()<=intervals.get(i-1).getEnd()){
                intervals.set(i-1, new Interval(intervals.get(i-1).getStart(), intervals.get(i).getEnd()));
                intervals.remove(i);
            }
            else i++;
        }
    }
}
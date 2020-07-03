package arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
Given an array, move all the 0 to the left while maintaining the order of the other elements
Example: 1, 0, 2, 0, 3, 0 => 0, 0, 0, 1, 2, 3
*/

public class MoveArray {
    private static Integer arr[];
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = Arrays.stream(br.readLine().split("[\\s,]+")).map(Integer::parseInt).toArray(Integer[]::new);
        int read = arr.length-1, write = arr.length-1;
        while(read>=0){
            if(arr[read]==0){
                // Keep the write at this position
                // Move read back
                read--;
            }else{
                arr[write] = swap(arr[read], arr[read]=arr[write]);
                read--;
                write--;
            }
        }
        Arrays.stream(arr).forEach(System.out::println);
    }
    static int swap(int a, int b){
        return a;
    }
}
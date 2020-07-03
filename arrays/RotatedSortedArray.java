package arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

    
/*Find an element in a rotated sorted array

Solution: binary search

Check first if the array is rotated. If not, apply normal binary search

If rotated, find pivot (smallest element, only element whose previous is bigger)

Then, check if the element is in 0..pivot-1 or pivot..len-1
*/

public class RotatedSortedArray {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] arr = Arrays.stream(br.readLine().split("[\\s,]+")).map(Integer::parseInt).toArray(Integer[]::new);
        int key = Integer.parseInt(br.readLine());
        
        // Check if array is rotated
        // 8 9 10 1 2 3 4 5 6 7
        if(arr[0]<arr[arr.length-1]){
            Arrays.binarySearch(arr, key);
        }
        
        // Check Pivot
        int pivot = 0;
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1])
                pivot = i-1;
        }

        // Check pivot division
        if(key < arr[pivot] && key > arr[0])
            System.out.println(Arrays.binarySearch(arr, 0, pivot+1, key));

        else if(key > arr[pivot+1] && key<arr[arr.length-1])
            System.out.println(Arrays.binarySearch(arr, pivot+1, arr.length, key));
    }       
    
}
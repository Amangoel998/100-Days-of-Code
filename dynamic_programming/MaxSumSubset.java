package dynamic_programming;

import java.io.*;
import java.util.*;

/*
Given an array of integers, find the subset of non-adjacent elements with the maximum sum. Calculate the sum of that subset.

For example, given an array arr=[-2, 1, 3, -4, 5] we have the following possible subsets:

Subset      Sum
[-2, 3, 5]   6
[-2, 3]      1
[-2, -4]    -6
[-2, 5]      3
[1, -4]     -3
[1, 5]       6
[3, 5]       8

Testcase#9 Excpected output = 15142193
Testcase#7 Excpected output = 81660407
Testcase#3 Excpected output = 107352889
*/

public class MaxSumSubset {

    static int maxSubsetSum(Integer[] arr) {
        memo = new int[arr.length+1];
        Arrays.fill(memo, Integer.MIN_VALUE);
        memo[0] = arr[0];
        memo[1] = arr[1];
        // return Math.max(maxYet(arr.length-2, arr),maxYet(arr.length-1, arr));
        return maxYet(arr);
    }
    static int[] memo;
    /*
    // Top Down Approach
    static int maxYet(int n, Integer[] arr){
        if(n<0)
            return 0;
        if(memo[n]!=Integer.MIN_VALUE)
            return memo[n];
        int result = Integer.MIN_VALUE;
        for(int i=n-2;i>=0;i--){
            int value = maxYet(i, arr);
            memo[n] = Math.max(Math.max(arr[n], value) , value+arr[n]);
            memo[i] = Math.max(memo[i], arr[n]);
            if(memo[n]>result)
                result = memo[n];
        }
        return result;
    }
    */
    
    // Bottom up
    
    static int maxYet(Integer[] arr){
        memo[0] = arr[0];
        memo[1] = arr[1];
        memo[arr.length] = Integer.MIN_VALUE;
        for(int i=2;i<arr.length;i++){
            memo[i] = Math.max(memo[i-1], Math.max(memo[i-2], memo[i-2]+arr[i]));
            memo[i] = Math.max(memo[i], arr[i]);
            if(memo[i]>memo[arr.length])
                memo[arr.length] = memo[i];
        }
        return memo[arr.length];
    }

    // private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        // int n = scanner.nextInt();
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");


        // String[] arrItems = scanner.nextLine().split(" ");
        // scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // for (int i = 0; i < n; i++) {
        //     int arrItem = Integer.parseInt(arrItems[i]);
        //     arr[i] = arrItem;
        // }
        BufferedReader br = new BufferedReader(new FileReader(new File("").getAbsolutePath()+"/dynamic_programming/MaxSumSubset Testcase#3.txt"));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = Arrays.stream(br.readLine().split("[\\s,]+")).map(Integer::parseInt).toArray(Integer[]::new);
        int res = maxSubsetSum(arr);

        System.out.println(String.valueOf(res));

        // scanner.close();
        br.close();
    }
}

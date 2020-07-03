package arrays;
import java.io.*;
import java.util.*;

/*
Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass?
*/

public class DailyProblem1_Easy {
    public static void main(final String args[]) throws Exception {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final String str_list = br.readLine();
        final int k = Integer.parseInt(br.readLine());
        final HashMap<Integer, Integer> map = new HashMap<>();
        Integer[] list = Arrays.stream(str_list.split("[\\s,]+")).map(Integer::parseInt).toArray(Integer[]::new);

        for(int a: list){
            if(map.containsKey(k-a) && map.get(k-a) == a){
                System.out.println("True"+"\n"+a+" "+(k-a));
                break;
            }
            else
                map.put(a, k-a);
        }
        System.out.println("False");
    }
}
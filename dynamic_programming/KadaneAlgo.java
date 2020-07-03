package dynamic_programming;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class KadaneAlgo {
    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Integer[] list = Arrays.stream(str.split("[\\s,]+")).map(Integer::parseInt).toArray(Integer[]::new);

        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i=0;i<list.length;i++){
            count = count + list[i];
            if(count>max)
                max = count;
            if(count<0)
                count = 0;
        }
        System.out.println(max);
    }
}

package dynamic_programming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
    Child can take 1, 2 or 3 steps up a stairs
    Find total possibilities
                  13
               7  __
            4  __|  |
         2  __|     |
      1  __|        |
      __|           |
    _|______________|
    0  1  2  3  4  5
*/

public class TripleSteps {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        memo = new long[N+1];
        Arrays.fill(memo, -1);
        memo[0] = 0; memo[1] = 1;
        System.out.println(tripleSteps(N));
    }

    static int N;
    static long[] memo;

    static long tripleSteps(int n) {
        if (n > 0 && memo[n] != -1)
            return memo[n];
        if (n < 0)
            return 0;
        else if (n == 0)
            return 1;
        return tripleSteps(n - 1) + tripleSteps(n - 2) + tripleSteps(n - 3);
    }
}
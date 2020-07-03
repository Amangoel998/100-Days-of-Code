package arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class RotateMatrix {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter N");
        int n = Integer.parseInt(br.readLine());
        Integer[][] matrix = new Integer[n][n];
        for (int i = 0; i < n; i++) {
            Integer[] arr = Arrays.stream(br.readLine().split("[\\s,]+")).map(Integer::parseInt)
                    .toArray(Integer[]::new);
            if (arr.length != n)
                throw new Exception("Incorrect Input");
            matrix[i] = arr;
        }
        rotateMatrix(matrix, n);
        for(Integer[] x:matrix){
            for(Integer y:x)
                System.out.print(y+" ");
            System.out.println();
        }
    }

    private static void rotateMatrix(Integer[][] matrix, int n) {
        for (int layer = 0; layer < n / 2; layer++) {
            int start = layer;
            int last = n - layer - 1;

            for (int j = start; j < last; j++) {

                // Save top left
                int temp = matrix[start][j];

                // bottom left -> top left
                matrix[start][j] = matrix[last-j][start];

                // bottom right -> bottom left
                matrix[last-j][start] = matrix[last][last-j];

                // top right -> bottom right
                matrix[last][last-j] = matrix[start+j][last];

                // top right -> top left
                matrix[start+j][last] = temp;
            }
        }
    }
}
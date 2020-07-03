import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class TestClass {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        System.out.println("Hi, " + name + ".");
        
        Scanner s = new Scanner(System.in);
        String name2 = s.nextLine();
        System.out.println("Hi, " + name2 + ".");

        Integer[] list = Arrays.stream(name.split("[\\s,]+")).map(Integer::parseInt).toArray(Integer[]::new);
        int a = 2, b = 1;
        b = swap(++a, a=b);
        System.out.println(a+" "+b);
    }

    static int swap(int a, int b){
        return a;
    }
}

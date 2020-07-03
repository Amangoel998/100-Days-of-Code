package strings;
import java.util.*;

/*

    Objective:
        Print Yes if he can use the magazine to create an untraceable replica of his ransom note. Otherwise, print No.
    Sample Input 0:
        6 4
        give me one grand today night
        give one grand today

    Sample Output 0:
        Yes
*/

public class RansomNote {

    static void checkMagazine(String[] magazine, String[] note) {
        Hashtable<String, Integer> magazine_freq = new Hashtable<>();
        for(int i=0;i<magazine.length;i++){
            if(magazine_freq.get(magazine[i])!=null)
                magazine_freq.put(magazine[i], magazine_freq.get(magazine[i])+1);
            else
                magazine_freq.put(magazine[i], 1);
        }
        for (String word : note) {
            System.out.println(word);
            if(magazine_freq.get(word)==null){
                System.out.println("No");
                return;
            }else if(magazine_freq.get(word)>0)
                magazine_freq.put(word, magazine_freq.get(word)-1);
            else{
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}

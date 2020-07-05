import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static int N;
    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int cnt = 0;
        int swap = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N-1; j++){
                if(a[j]>a[j+1]){
                    swap = a[j+1];
                    a[j+1] = a[j];
                    a[j] = swap;
                    cnt++;
                }
            }
        }
        System.out.println("Array is sorted in " + cnt + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[N-1]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        N = n;
        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}

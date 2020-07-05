package com.hackerrank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    private static int N;
    private static int[] prices2;

    static void merge(int[] arr, int min, int max){
        int mid = (min+max)/2;
        int i=min;
        int j = mid+1;
        int k = min;

        while(i<=mid && j <= max){
            if(arr[i]<arr[j]){
                prices2[k++] = arr[i++];
            } else{
                prices2[k++] = arr[j++];
            }
        }
        while(j<=max){
            prices2[k++] = arr[j++];
        }
        while(i<=mid){
            prices2[k++] = arr[i++];
        }

        for(int l = min; l <=max; l++){
            arr[l] = prices2[l];
        }

    }

    static void partition(int[] arr, int min, int max){
        if(min == max) return;
        int mid = (min+max)/2;

        partition(arr, min, mid);
        partition(arr, mid+1, max);
        merge(arr, min, max);
    }

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        partition(prices, 0, N-1);
        int cnt = 0;
        int sum = 0;
        for(int i=0; i<N; i++){
            sum += prices[i];
            if(sum > k) break;
            cnt++;
        }
        return cnt;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);
        N=n;
        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];
        prices2 = new int[n];
        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

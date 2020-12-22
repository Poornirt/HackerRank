import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class swap {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int arrLen = arr.length;
        int count = 0;
        int [] sarr = arr.clone();
        Arrays.sort(sarr);

        for (int i = 0; i < arrLen; i++) {
            if (arr[i] != sarr[i]) {
                count++;
                for (int j = i + 1; j < arrLen; j++) {
                    if (arr[j] == sarr[i] ) {
                        int tmp = arr[j];
                        arr[j] = arr[i];
                        arr[i] = tmp;
                        break;
                    }
                }
            }
        }
        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        System.out.println(res);

        scanner.close();
    }
}
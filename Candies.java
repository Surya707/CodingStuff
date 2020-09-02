package algos;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Candies {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        long L2R[]=new long[n];
        long R2L[]=new long[n];
        long res[]=new long[n];
        long result=0;
        Arrays.fill(L2R,1);
        Arrays.fill(R2L,1);
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]>arr[i-1])
            {
                L2R[i]+=L2R[i-1];
            }
        }
        for(int i=n-2;i>=0;i--)
        {
            if(arr[i]>arr[i+1])
            {
                R2L[i]+=R2L[i+1];
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            res[i]=Math.max(L2R[i],R2L[i]);
        }
        for(int i=0;i<arr.length;i++)
        {
            result+=res[i];
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

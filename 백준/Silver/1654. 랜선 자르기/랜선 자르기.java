import java.io.*;
import java.util.*;

public class Main {

    static int K, N;
    static long[] arr;
    static long max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new long[K];

        max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Long.parseLong(br.readLine());

            if (max < arr[i]) max = arr[i];
        }
        max++;

        long answer = binarySearch();
        bw.write(answer + "");
        bw.close();
    }

    public static long binarySearch() {
        long min = 0;
        long mid = 0;

        while (min < max) {
            mid = (min + max) / 2;

            long count = 0;
            for (int i = 0; i < arr.length; i++) {
                count += arr[i] / mid;
            }

            if (count < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min - 1;
    }
}
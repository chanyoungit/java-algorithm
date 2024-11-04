import java.io.*;
import java.util.*;

class Main {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int lis = 0;
        for (int i = 0; i < N; i++) {
            int idx = search(arr[i], 0, lis, lis + 1);

            if (idx == -1) {
                dp[lis++] = arr[i];
            } else {
                dp[idx] = arr[i];
            }
        }

        bw.write(lis + "");
        bw.close();
    }

    public static int search(int num, int start, int end, int size) {
        int res = 0;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (num <= dp[mid]) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (start == size) {
            return -1;
        } else {
            return res;
        }
    }
}
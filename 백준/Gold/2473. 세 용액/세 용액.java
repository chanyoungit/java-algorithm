import java.io.*;
import java.util.*;

public class Main {

    static long[] arr;
    static long[] answer;
    static long max = 3000000000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        arr = new long[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        answer = new long[3];
        for (int i = 0; i < N - 2; i++) {
            search(i);
        }

        bw.write(answer[0] + " " + answer[1] + " " + answer[2]);
        bw.close();
    }

    public static void search(int index) {
        int s = index + 1;
        int e = arr.length - 1;

        while (s < e) {
            long sum = arr[s] + arr[e] + arr[index];
            long absSum = Math.abs(sum);

            if (absSum < max) {
                answer[0] = arr[index];
                answer[1] = arr[s];
                answer[2] = arr[e];
                max = absSum;
            }

            if (sum > 0) {
                e--;
            } else {
                s++;
            }
        }
    }
}
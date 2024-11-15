import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;
    static int min;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        answer = new int[2];
        answer[0] = 0;
        answer[1] = 0;
        min = Integer.MAX_VALUE;

        binaryCheck();

        bw.write(answer[0] + " " + answer[1]);
        bw.close();
    }

    public static void binaryCheck() {
        int s = 0;
        int e = N - 1;

        while (e -s != 0) {
            int sum = arr[s] + arr[e];

            if (min > Math.abs(sum)) {
                min = Math.abs(sum);
                answer[0] = arr[s];
                answer[1] = arr[e];
            }

            if (min == 0) {
                return;
            } else if (sum > 0) {
                e--;
            } else {
                s++;
            }
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int answer = 0;
        int s = 0;
        int e = n - 1;
        int sum = 0;

        while (s < e) {
            sum = arr[s] + arr[e];

            if (sum == x) {
                answer++;
                s++;
            } else if (sum < x) {
                s++;
            } else {
                e--;
            }
        }

        bw.write(answer + "");
        bw.close();
    }
}
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = 0;
        int sum = arr[0];
        int answer = Integer.MAX_VALUE;

        while (s <= e) {
            if (sum >= S) {
                answer = Math.min(answer, e - s + 1);
                if (s == e) break;
                sum -= arr[s++];
            } else {
                e++;
                if (e >= N) break;
                sum += arr[e];
            }
        }

        if (answer == Integer.MAX_VALUE) {
            bw.write("0");
        } else {
            bw.write(answer + "");
        }
        
        bw.close();
    }
}
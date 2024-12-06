import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (s == e) {
                bw.write("1\n");
            } else if (e - s == 1) {
                if (arr[s] == arr[e]) bw.write("1\n");
                else bw.write("0\n");
            } else {
                boolean check = true;
                while (s < e) {
                    if (arr[s] == arr[e]) {
                        s++;
                        e--;
                    } else {
                        check = false;
                        bw.write("0\n");
                        break;
                    }
                }

                if (check) bw.write("1\n");
            }
        }

        bw.close();
    }
}
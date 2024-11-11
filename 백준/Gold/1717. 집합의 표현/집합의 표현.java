import java.io.*;
import java.util.*;

class Main {

    static int[] index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        index = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            index[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == 0) {
                union(b, c);
            } else {
                b = find(b);
                c = find(c);
                if (b == c) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.close();
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a > b) {
                index[a] = b;
            } else {
                index[b] = a;
            }
        }
    }

    public static int find(int a) {
        if (index[a] == a) {
            return a;
        }
        return index[a] = find(index[a]);
    }
}
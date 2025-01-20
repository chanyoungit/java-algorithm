import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] check = new int[N];
        int[] value = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            if (check[i] == 0) {
                deque.addFirst(value[i]);
            }
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            deque.addLast(Integer.parseInt(st.nextToken()));
            sb.append(deque.pollFirst() + " ");
        }

        bw.write(sb.toString());
        bw.close();
    }
}
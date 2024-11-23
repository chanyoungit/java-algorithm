import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            switch (a) {
                case 1:
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                case 2:
                    deque.add(Integer.parseInt(st.nextToken()));
                    break;

                case 3:
                    if (deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.poll() + "\n");
                    break;

                case 4:
                    if (deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.pollLast() + "\n");
                    break;

                case 5:
                    sb.append(deque.size() + "\n");
                    break;

                case 6:
                    if (deque.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;

                case 7:
                    if (deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.peek() + "\n");
                    break;

                case 8:
                    if (deque.isEmpty()) sb.append("-1\n");
                    else sb.append(deque.peekLast() + "\n");
                    break;
            }
        }

        bw.write(sb.toString() + "");
        bw.close();
    }
}
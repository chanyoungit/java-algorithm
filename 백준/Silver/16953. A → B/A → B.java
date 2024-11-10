import java.io.*;
import java.util.*;

class Node {
    long num;
    int depth;

    public Node(long num, int depth) {
        this.num = num;
        this.depth = depth;
    }
}

public class Main {

    static long B;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        answer = Integer.MAX_VALUE;
        bfs(A, 0);

        if (answer == Integer.MAX_VALUE) {
            bw.write(-1 + "");
        } else {
            answer += 1;
            bw.write(answer + "");
        }

        bw.close();
    }

    public static void bfs(int a, int b) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, b));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            long num = now.num;
            int depth = now.depth;

            if (num == B) {
                answer = Math.min(answer, depth);
                return;
            }

            if (num > B) continue;

            queue.add(new Node(num * 2, depth + 1));

            String str = String.valueOf(num);
            str += "1";
            long strNum = Long.parseLong(str);
            queue.add(new Node(strNum, depth + 1));
        }
    }
}
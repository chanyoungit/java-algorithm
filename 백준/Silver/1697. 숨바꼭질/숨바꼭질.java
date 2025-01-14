import java.io.*;
import java.util.*;

class Node {
    int num;
    int cnt;

    public Node(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}

public class Main {

    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visit = new boolean[100002];

        bw.write(bfs(N, K) + "");
        bw.close();
    }

    public static int bfs(int N, int K) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int num = now.num;
            int cnt = now.cnt;

            if (num > 100001 || num < 0) {
                continue;
            }

            if (num == K) {
                return cnt;
            }

            if (!visit[num]) {
                visit[num] = true;

                for (int i = 0; i < 3; i++) {
                    if (i == 0) {
                        queue.add(new Node(num * 2, cnt + 1));
                    } else if (i == 1) {
                        queue.add(new Node(num + 1, cnt + 1));
                    } else {
                        queue.add(new Node(num - 1, cnt + 1));
                    }
                }
            }
        }

        return 0;
    }
}
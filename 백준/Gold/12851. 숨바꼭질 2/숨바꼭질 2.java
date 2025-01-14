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

    static int[] visit;
    static int time, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visit = new int[100002];
        bfs(N, K);
        bw.write(time + "\n");
        bw.write(count + "\n");
        bw.close();
    }

    public static void bfs(int N, int K) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(N, 0));

        count = 0;  // 방법의 수
        time = Integer.MAX_VALUE;  // 가장 빠른 시간

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int num = now.num;
            int cnt = now.cnt;

            if (num > 100001 || num < 0) {
                continue;
            }

            if (time < cnt) {
                continue;
            }

            if (num == K && count == 0) {
                time = cnt;
                count += 1;
            } else if (num == K && count != 0) {
                count += 1;
            }

            if (visit[num] == 0 || visit[num] >= cnt) {

                visit[num] = cnt;

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
    }
}
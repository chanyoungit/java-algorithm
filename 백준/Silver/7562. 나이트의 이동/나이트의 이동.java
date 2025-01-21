import javax.swing.event.MenuDragMouseListener;
import java.io.*;
import java.util.*;

class Node {
    int start;
    int end;
    int cnt;

    Node(int start, int end, int cnt) {
        this.start = start;
        this.end = end;
        this.cnt = cnt;
    }
}

public class Main {

    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[][] arr;
    static int l;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            l = Integer.parseInt(br.readLine());

            arr = new int[l][l];
            visit = new boolean[l][l];

            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            sb.append(bfs(startX, startY, endX, endY) + "\n");
        }

        bw.write(sb.toString());
        bw.close();
    }

    public static int bfs(int startX, int startY, int endX, int endY) {
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n1.cnt - n2.cnt;
            }
        });

        queue.add(new Node(startX, startY, 0));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nowX = now.start;
            int nowY = now.end;
            int nowCnt = now.cnt;

            if (nowX == endX && nowY == endY) {
                return nowCnt;
            }

            for (int i = 0; i < 8; i++) {
                int x = nowX + dx[i];
                int y = nowY + dy[i];

                if (x >= 0 && x < l && y >= 0 && y < l) {
                    if (!visit[x][y]) {
                        visit[x][y] = true;
                        queue.add(new Node(x, y, nowCnt + 1));
                    }
                }
            }
        }

        return 0;
    }
}
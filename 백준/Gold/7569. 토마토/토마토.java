import java.io.*;
import java.util.*;

// map.put(str, map.getOrDefault(str, 0) + 1);
// ArrayList<String> al = new ArrayList<>(map.keySet());
// ArrayList<Integer> al = new ArrayList<>(map.values());
// Collections.sort(al, new Comparator<String>() { ... return o1.compareTo(o2)};

// public int compare(Node o1, Node o2) {
//    return Double.compare(o1.weight, o2.weight);
// }

class Node {
    int h;
    int x;
    int y;
    int depth;

    public Node(int h, int x, int y, int depth) {
        this.h = h;
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int[][][] arr;
    static boolean[][][] visit;

    static int M, N, H;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        visit = new boolean[H][N][M];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < M; k++) {
                    arr[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        Queue<Node> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 1) {
                        queue.add(new Node(i, j, k, 0));
                    }
                }
            }
        }

        int answer = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nowH = now.h;
            int nowX = now.x;
            int nowY = now.y;
            int depth = now.depth;

            if (answer < depth) {
                answer = depth;
            }

            for (int i = 0; i < 4; i++) {
                int x = nowX + dx[i];
                int y = nowY + dy[i];

                if (x >= 0 && x < N && y >= 0 && y < M) {
                    if (arr[nowH][x][y] == 0) {
                        arr[nowH][x][y] = 1;
                        queue.add(new Node(nowH, x, y, depth + 1));
                    }
                }
            }

            int plusH = nowH + 1;
            int minusH = nowH - 1;

            if (plusH < H) {
                if (arr[plusH][nowX][nowY] == 0) {
                    arr[plusH][nowX][nowY] = 1;
                    queue.add(new Node(plusH, nowX, nowY, depth + 1));
                }
            }

            if (minusH >= 0) {
                if (arr[minusH][nowX][nowY] == 0) {
                    arr[minusH][nowX][nowY] = 1;
                    queue.add(new Node(minusH, nowX, nowY, depth + 1));
                }
            }
        }


        boolean check = true;

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (arr[i][j][k] == 0) {
                        check = false;
                    }

//                    bw.write(arr[i][j][k] + " ");
                }
//                bw.write("\n");
            }
        }

        if (!check) {
            bw.write("-1 ");
        } else {
            bw.write(answer + "");
        }

        bw.close();
    }
}
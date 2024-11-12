import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;
    int depth;
    int status; // 파이스 상태 -> 0:가로, 1:세로, 2:대각선

    public Node(int x, int y, int depth, int status) {
        this.x = x;
        this.y = y;
        this.depth = depth;
        this.status = status;
    }
}

public class Main {

    static int[][] dx = {{0, 1, 0}, {1, 1, 0}, {0, 1, 1}};  // X축
    static int[][] dy = {{1, 1, 0}, {0, 1, 0}, {1, 0, 1}};  // Y축

    static int[][] arr; // 배열 저장

    static int answer;  // 정답
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        answer = 0;

        if (arr[N - 1][N - 1] == 1) {
            bw.write(0 + "");
        } else {
            bfs(0, 1, 0, 0);
            bw.write(answer + "");
        }

        bw.close();
    }

    public static void bfs(int a, int b, int c, int d) {   // a:x, b:y, c:depth, d:status
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(a, b, c, d));

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int x = now.x;
            int y = now.y;
            int depth = now.depth;
            int status = now.status;    // 파이스 상태 -> 0:가로, 1:세로, 2:대각선

            if (x == N - 1 && y == N - 1) {
                answer++;
                continue;
            }

            if (status == 0) {
                for (int i = 0; i < 2; i++) {
                    int xNext = x + dx[0][i];
                    int yNext = y + dy[0][i];

                    if (xNext >= 0 && yNext >= 0 && xNext < N && yNext < N) {
                        if (arr[xNext][yNext] == 0) {
                            if (i == 0) {
                                queue.add(new Node(xNext, yNext, depth + 1, 0));
                            } else {
                                if (arr[xNext - 1][yNext] == 0 && arr[xNext][yNext - 1] == 0) {
                                    queue.add(new Node(xNext, yNext, depth + 1, 2));
                                }
                            }
                        }
                    }
                }
            } else if (status == 1) {
                for (int i = 0; i < 2; i++) {
                    int xNext = x + dx[1][i];
                    int yNext = y + dy[1][i];

                    if (xNext >= 0 && yNext >= 0 && xNext < N && yNext < N) {
                        if (arr[xNext][yNext] == 0) {
                            if (i == 0) {
                                queue.add(new Node(xNext, yNext, depth + 1, 1));
                            } else {
                                if (arr[xNext - 1][yNext] == 0 && arr[xNext][yNext - 1] == 0) {
                                    queue.add(new Node(xNext, yNext, depth + 1, 2));
                                }
                            }
                        }
                    }
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    int xNext = x + dx[2][i];
                    int yNext = y + dy[2][i];

                    if (xNext >= 0 && yNext >= 0 && xNext < N && yNext < N) {
                        if (arr[xNext][yNext] == 0) {
                            if (i == 0) {
                                queue.add(new Node(xNext, yNext, depth + 1, 0));
                            } else if (i == 1) {
                                queue.add(new Node(xNext, yNext, depth + 1, 1));
                            } else {
                                if (arr[xNext - 1][yNext] == 0 && arr[xNext][yNext - 1] == 0) {
                                    queue.add(new Node(xNext, yNext, depth + 1, 2));
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
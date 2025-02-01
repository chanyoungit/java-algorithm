import javax.lang.model.SourceVersion;
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
    int x;
    int y;
    int weight;
    int power;

    Node(int x, int y, int weight, int power) {
        this.x = x;
        this.y = y;
        this.weight = weight;
        this.power = power;
    }
}

public class Main {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[] chArr = new char[M + 1];
        int[][] arr = new int[N + 1][M + 1];
        boolean[][][] visit = new boolean[N + 1][M + 1][2];

        for (int i = 1; i <= N; i++) {
            chArr = br.readLine().toCharArray();

            for (int j = 1; j <= M; j++) {
                arr[i][j] = chArr[j - 1] - '0';
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n1.weight - n2.weight;
            }
        });

        queue.add(new Node(1, 1, 1, 1));
        int answer = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int xNow = now.x;
            int yNow = now.y;
            int weightNow = now.weight;
            int powerNow = now.power;

            if (xNow == N && yNow == M) {
                answer = weightNow;
                break;
            }

            if (visit[xNow][yNow][powerNow]) continue;
            visit[xNow][yNow][powerNow] = true;

            for (int i = 0; i < 4; i++) {
                int x = xNow + dx[i];
                int y = yNow + dy[i];

                if (x >= 1 && x <= N && y >= 1 && y <= M) {
                    if (!visit[x][y][powerNow]) {
                        if (arr[x][y] == 0) {
                            queue.add(new Node(x, y, weightNow + 1, powerNow));
                        } else {
                            if (powerNow == 1) {
                                queue.add(new Node(x, y, weightNow + 1, 0));
                            }
                        }
                    }
                }
            }
        }

        if (answer == 0) {
            bw.write("-1");
        } else {
            bw.write(answer + "");
        }

        bw.close();
    }
}
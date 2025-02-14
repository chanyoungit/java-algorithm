import java.io.*;
import java.util.*;

// map.put(str, map.getOrDefault(str, 0) + 1);
// ArrayList<String> al = new ArrayList<>(map.keySet());
// ArrayList<Integer> al = new ArrayList<>(map.values());
// Collections.sort(al, new Comparator<String>() { ... return o1.compareTo(o2)};

// public int compare(Node o1, Node o2) {
//    return Double.compare(o1.weight, o2.weight);
// }

// Arrays.sort(a, Collections.reverseOrder())

// Lower Bound -> LIS
//while (s < e) {
//    int mid = (s + e) / 2;
//    if (al.get(mid) >= num) {
//        e = mid;
//    } else {
//        s = mid + 1;
//    }
//}

class Node {
    int x;
    int y;
    int r;

    Node(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}

public class Main {

    static HashMap<Node, Integer> map;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            arr = new int[n][3];
            map = new HashMap<>();

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());   //반지름 X
                arr[j][1] = Integer.parseInt(st.nextToken());   //반지름 Y
                arr[j][2] = Integer.parseInt(st.nextToken());   //반지름 길이

                sqrt(x1, y1, arr[j][0], arr[j][1], arr[j][2]);
                sqrt(x2, y2, arr[j][0], arr[j][1], arr[j][2]);
            }

            int cnt = 0;
            for (int j : map.values()) {
                if (j == 1) {
                    cnt++;
                }
            }

            sb.append(cnt + "\n");

            map.clear();
        }

        bw.write(sb.toString());
        bw.close();
    }

    public static void sqrt(int x, int y, int cx, int cy, int cr) {
        int dx = x - cx;
        int dy = y - cy;

        dx *= dx;
        dy *= dy;

        int distance = (int) Math.sqrt(dx + dy);

        if (distance < cr) {
            boolean bl = false;
            for (Node node : map.keySet()) {
                if (node.x == cx && node.y == cy && node.r == cr) {
                    map.put(node, map.get(node) + 1);
                    bl = true;
                    break;
                }
            }

            if (!bl) {
                map.put(new Node(cx, cy, cr), 1);
            }
        }
    }
}
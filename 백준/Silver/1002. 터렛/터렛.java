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

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            check(x1, y1, r1, x2, y2, r2);
        }

        bw.write(sb.toString());
        bw.close();
    }

    public static void check(int x1, int y1, int r1, int x2, int y2, int r2) {
        int dx = (int) Math.pow(x1 - x2, 2);
        int dy = (int) Math.pow(y1 - y2, 2);
        int drP = (int) Math.pow(r1 + r2, 2);
        int drM = (int) Math.pow(r1 - r2, 2);

        if (x1 == x2 && y1 == y2 && r1 == r2) {
            sb.append("-1\n");
        } else if (dx + dy == drP || dx + dy == drM) {
            sb.append("1\n");
        } else if (dx + dy < drM || dx + dy > drP) {
            sb.append("0\n");
        } else {
            sb.append("2\n");
        }
    }
}
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

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double x1 = Double.parseDouble(st.nextToken());
        double y1 = Double.parseDouble(st.nextToken());

        double x2 = Double.parseDouble(st.nextToken());
        double y2 = Double.parseDouble(st.nextToken());

        double x3 = Double.parseDouble(st.nextToken());
        double y3 = Double.parseDouble(st.nextToken());

        boolean bl = true;

        // 일직선상 있을 떄
        if ((x2 - x1) * (y3 - y1) == (y2 - y1) * (x3 - x1)) {
            bl = false;
        }

        // 두 점이 같을 떄
        if ((x1 == x2 && y1 == y2) || (x1 == x3 && y1 == y3) || (x2 == x3 && y2 == y3)) bl = false;

        // 동일한 x축 or y축에 존재할 때
        if ((x1 == x2 && x2 == x3) || (y1 == y2) && (y2 == y3)) bl = false;

        if (bl) {
            double[] distance = new double[3];
            distance[0] = check(x1, y1, x2, y2);
            distance[1] = check(x1, y1, x3, y3);
            distance[2] = check(x2, y2, x3, y3);

            Arrays.sort(distance);

            double answer1 = distance[0] * 2 + distance[1] * 2;
            double answer2 = distance[2] * 2 + distance[1] * 2;

            bw.write(answer2 - answer1 + "");

        } else {
            bw.write("-1.0");
        }

        bw.close();
    }

    public static double check(double x1, double y1, double x2, double y2) {
        double dx = x1 - x2;
        double dy = y1 - y2;

        dx *= dx;
        dy *= dy;

        return Math.sqrt(dx + dy);
    }
}
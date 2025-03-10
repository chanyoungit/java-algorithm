import java.io.*;
import java.util.*;

// map.put(str, map.getOrDefault(str, 0) + 1);
// ArrayList<String> al = new ArrayList<>(map.keySet());
// ArrayList<Integer> al = new ArrayList<>(map.values());
// Collections.sort(al, new Comparator<String>() { ... return o1.compareTo(o2)};
// String str = String.valueOf(ch).repeat(5);
// int[] alpha = new int[26];

//value = value.substring(0, value.length() - 1);
//value = new StringBuilder(value).reverse().toString();

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
// al.set(e, num);

// Math.round(num1 * 100.0) / 100.0 -> 3.14
// IFNULL(name, 'park') AS name, WHERE NAME IS NOT NULL, COUNT(DISTINCT NAME)

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        int maxNum = N * N;
        int check = 0;

        int x = 0;
        int y = 0;

        while (maxNum > 1) {
            if (check % 4 == 0) {
                while (true) {
                    arr[x][y] = maxNum;
                    x++;
                    if (x >= N || arr[x][y] != 0) {
                        x--;
                        break;
                    }
                    maxNum--;
                }
            } else if (check % 4 == 1) {
                while (true) {
                    arr[x][y] = maxNum;
                    y++;
                    if (y >= N || arr[x][y] != 0) {
                        y--;
                        break;
                    }
                    maxNum--;
                }
            } else if (check % 4 == 2) {
                while (true) {
                    arr[x][y] = maxNum;
                    x--;
                    if (x < 0 || arr[x][y] != 0) {
                        x++;
                        break;
                    }
                    maxNum--;
                }
            } else {
                while (true) {
                    arr[x][y] = maxNum;
                    y--;
                    if (y < 0 || arr[x][y] != 0) {
                        y++;
                        break;
                    }
                    maxNum--;
                }
            }

            check++;
        }

        int answerX = 0;
        int answerY = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                bw.write(arr[i][j] + " ");
                if (arr[i][j] == num) {
                    answerX = i;
                    answerY = j;
                }
            }
            bw.write("\n");
        }

        answerX++;
        answerY++;

        bw.write(answerX + " " + answerY);

        bw.close();
    }
}
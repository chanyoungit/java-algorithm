import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        char[] arr = br.readLine().toCharArray();     // 주어진 문자열을 char 배열로 바로 변환

        int[][] check = new int[arr.length][26];
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i] - 'a';

            for (int j = 0; j < 26; j++) {      // 누적합
                if (i != 0) check[i][j] += check[i - 1][j];
                if (j == num) check[i][j] += 1;
            }
        }

        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int num = st.nextToken().charAt(0) - 'a';
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (s == 0) {
                bw.write(check[e][num] + "\n");
            } else {
                bw.write(check[e][num] - check[s - 1][num] + "\n");
            }
        }

        bw.close();
    }
}
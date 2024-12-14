import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			boolean bl = true;
			int count = 0;
			int index = i + 1;

			while (b >= c) {
				b--;
				if (b == 0 || b == 1) {
					bw.write("#" + index + " " + "-1" + "\n");
					bl = false;
					break;
				}
				count++;
			}

			if (bl) {
				while (a >= b) {
					a--;
					if (a == 0) {
						bw.write("#" + index + " " + "-1" + "\n");
						bl = false;
						break;
					}
					count++;
				}
			}

			if (bl)
				bw.write("#" + index + " " + count + "\n");

		}

		bw.flush();
		bw.close();
		br.close();
	}
}
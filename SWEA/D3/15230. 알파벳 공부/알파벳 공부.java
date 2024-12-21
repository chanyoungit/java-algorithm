import java.io.*;
import java.util.StringTokenizer;

public class Solution {
	static boolean[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			char[] ch = str.toCharArray();

			int a = 97;
			int count = 0;

			for (int j = 0; j < ch.length; j++) {
				if (ch[j] == (char) a) {
					count++;
					a++;
				} else {
					break;
				}
			}

			int seq = i + 1;
			bw.write("#" + seq + " " + count + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
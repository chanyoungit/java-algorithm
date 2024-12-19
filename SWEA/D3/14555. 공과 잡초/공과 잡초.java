import java.io.*;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String str = br.readLine();
			char[] ch = str.toCharArray();
			int count = 0;

			for (int j = 0; j < ch.length - 1; j++) {
				if (ch[j] == '(') {
					if (ch[j + 1] == ')' || ch[j + 1] == '|')
						count++;
				} else if (ch[j] == '|') {
					if (ch[j + 1] == ')')
						count++;
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
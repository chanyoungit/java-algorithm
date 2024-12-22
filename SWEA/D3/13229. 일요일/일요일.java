import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String S = br.readLine();
			int result = check(S);
			
			bw.write("#" + test_case + " " + result + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static int check(String S) {
		switch (S) {
		case "MON":
			return 6;
		case "TUE":
			return 5;
		case "WED":
			return 4;
		case "THU":
			return 3;
		case "FRI":
			return 2;
		case "SAT":
			return 1;
		case "SUN":
			return 7;
		default:
			return 0;
		}
	}
}
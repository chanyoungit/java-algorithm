import java.io.*;
import java.util.*;

class Solution {
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb;
		
		int T = 10;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			char[][] arr = new char[8][8];
			
			for (int i=0; i<8; i++) {
				arr[i] = br.readLine().toCharArray();
			}
			
			int answer = 0;
			
			for (int i=0; i<8; i++) {		//가로
				for (int k=0; k<=8-N; k++) {
					int start = k;
					int end = start + N;
					
					String str = "";
					for (int j=start; j < end; j++) {
						str += arr[i][j];
					}
					
					sb = new StringBuilder(str);
					String reverseStr = sb.reverse().toString();
						
					if (str.equals(reverseStr)) {
						answer++;
					}
					
					sb.setLength(0);
				}
			}
			
			for (int i=0; i<8; i++) {
				for (int k=0; k<=8-N; k++) {
					int start = k;
					int end = start + N;
					
					String str = "";
					for (int j=start; j<end; j++) {
						str += arr[j][i];
					}
					
					sb = new StringBuilder(str);
					String reverseStr = sb.reverse().toString();
					
					if(str.equals(reverseStr)) {
						answer++;
					}
					
					sb.setLength(0);
				}
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
import java.io.*;
import java.util.*;

class Solution {
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[][] arr = new int[N][N];
			
			for (int i=0; i<N; i++) {
				char[] ch = br.readLine().toCharArray();
				
				for (int j=0; j<ch.length; j++) {
					arr[i][j] = (char)(ch[j] - '0');
				}
			}
			
			int mid = N / 2;
			int answer  = 0;
			
			int start = mid;
			int end = mid;
			
			for (int i=0; i<= mid; i++) {
				for (int j=start; j<=end; j++) {
					answer += arr[i][j];
				}
				if (i == mid) {
					continue;
				}
				start--;
				end++;
			}
			
			start++;
			end--;
			
			for (int i=mid+1; i<N; i++) {
				for (int j=start; j<=end; j++) {
					answer += arr[i][j];
				}
				start++;
				end--;
			}
			
			bw.write("#" + test_case + " " + answer + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
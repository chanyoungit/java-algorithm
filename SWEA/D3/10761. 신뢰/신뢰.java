import java.io.*;
import java.util.*;

public class Solution {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	
        	int answer = 0;
    		int timeB = 0;
    		int timeO = 0;
    		int indexB = 1;
    		int indexO = 1;
        	
        	for (int i=0; i<N; i++) {
        		String str = st.nextToken();
        		int num = Integer.parseInt(st.nextToken());
        		
        		if (str.equals("B")) {
        			int abs = Math.abs(num - indexB);
        			if (abs <= timeB) {
        				answer++;
        				timeO++;
        			} else {
        				answer += abs - timeB + 1;
        				timeO += abs - timeB + 1;
        			}
        			timeB = 0;
        			indexB = num;
        		} else {
        			int abs = Math.abs(num - indexO);
        			if (abs <= timeO) {
        				answer++;
        				timeB++;
        			} else {
        				answer += abs - timeO + 1;
        				timeB += abs - timeO + 1;
        			}
        			timeO = 0;
        			indexO = num;
        		}
        	}
        	
        	bw.write("#" + test_case + " " + answer + " \n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
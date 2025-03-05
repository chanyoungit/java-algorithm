import java.io.*;
import java.util.*;

public class Solution {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        int[] arr = {20,40,60,80,100,120,140,160,180,200};
        
        for (int test_case = 1; test_case <= T; test_case++) {
        	int N = Integer.parseInt(br.readLine());
        	int answer = 0;
        	
        	for (int i=0; i<N; i++) {
        		st = new StringTokenizer(br.readLine());
        		int a = Integer.parseInt(st.nextToken());
        		int b = Integer.parseInt(st.nextToken());
        		int number = (int)Math.pow(a, 2) + (int)Math.pow(b,2);
        		int cnt = 10;
        		
        		for (int j=9; j>=0; j--) {
        			if (number > Math.pow(arr[j], 2)) {
        				break;
        			}
        			cnt--;
        		}
        		
        		if (cnt == 10) {
        			continue;
        		}
        		
        		answer += 11 - arr[cnt] / 20;
        	}
        	
        	bw.write("#" + test_case + " " + answer + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}